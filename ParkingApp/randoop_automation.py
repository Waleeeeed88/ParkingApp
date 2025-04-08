#!/usr/bin/env python3
import os
import subprocess
import shutil
import platform
import argparse

def run_command(command, cwd=None):
    """Run a shell command and return the output."""
    try:
        result = subprocess.run(command, shell=True, check=True, text=True,
                                stdout=subprocess.PIPE, stderr=subprocess.PIPE, cwd=cwd)
        print(result.stdout)
        return result.stdout
    except subprocess.CalledProcessError as e:
        print(f"Error executing command: {command}")
        print(f"Error message:\n{e.stderr or e.stdout}")
        return None

def automate_randoop(project_dir, test_class, output_limit=500, target_package="randoopTestParkingApp"):
    """
    Automate Randoop test generation and JaCoCo coverage for Java classes
    
    Args:
        project_dir: Path to the project directory
        test_class: Fully qualified name of the class to test (e.g., com.parkingapp.ParkingSpace)
        output_limit: Maximum number of tests to generate
        target_package: Target package for the generated tests
    """
    # Ensure we're working with absolute path
    project_dir = os.path.abspath(project_dir)
    classpath_sep = ";" if platform.system() == "Windows" else ":"
    
    print(f"\n{'=' * 80}")
    print(f"Randoop Automation for {test_class}")
    print(f"Target package: {target_package}")
    print(f"{'=' * 80}")
    
    # Step 1: Compile the project
    print("\nStep 1: Compiling the project...")
    run_command("mvn clean", project_dir)
    run_command("mvn compile", project_dir)
    run_command("mvn dependency:copy-dependencies", project_dir)
    
    # Step 2: Generate test cases with Randoop
    print("\nStep 2: Generating test cases with Randoop...")
    classes_dir = os.path.join(project_dir, "target", "classes")
    dep_dir = os.path.join(project_dir, "target", "dependency")
    randoop_jar = os.path.join(project_dir, "randoop-lib", "randoop-all-4.2.1.jar")
    
    # Build classpath including dependencies
    classpath = f"{classes_dir}{classpath_sep}{dep_dir}/*{classpath_sep}{randoop_jar}"
    
    randoop_cmd = (
        f"java -classpath \"{classpath}\" "
        f"randoop.main.Main gentests "
        f"--testclass={test_class} --output-limit={output_limit} "
    )
    
    run_command(randoop_cmd, project_dir)
    
    # Step 3: Clean temporary .class files
    print("\nStep 3: Cleaning temporary .class files...")
    for file in os.listdir(project_dir):
        if file.endswith(".class"):
            try:
                os.remove(os.path.join(project_dir, file))
                print(f"Deleted: {file}")
            except Exception as e:
                print(f"Failed to delete {file}: {e}")
    
    # Step 4: Update package name in generated test files
    print(f"\nStep 4: Adding package declaration '{target_package}' to test files...")
    
    test_files = [f for f in os.listdir(project_dir) 
                 if (f.startswith("RegressionTest") or f.startswith("ErrorTest")) 
                 and f.endswith(".java")]
    
    for test_file in test_files:
        file_path = os.path.join(project_dir, test_file)
        
        # Read file content
        with open(file_path, 'r', encoding='utf-8') as f:
            content = f.read()
        
        # Add package declaration if not present
        if not content.strip().startswith("package"):
            content = f"package {target_package};\n\n{content}"
        else:
            # Replace existing package declaration
            content = content.replace(content.split(';')[0] + ';', f"package {target_package};")
        
        # Add imports for the tested class
        if test_class not in content:
            import_line = f"import {test_class};\n"
            # Find the right place to add import
            if "import " in content:
                last_import_pos = content.rfind("import ")
                last_import_end = content.find(";", last_import_pos) + 1
                content = content[:last_import_end] + "\n" + import_line + content[last_import_end:]
            else:
                # Insert after package declaration
                pkg_end = content.find(";") + 1
                content = content[:pkg_end] + "\n\n" + import_line + content[pkg_end:]
        
        # Write updated content back
        with open(file_path, 'w', encoding='utf-8') as f:
            f.write(content)
            
        print(f"Updated package in {test_file}")
    
    # Step 5: Move test files to target package directory
    print(f"\nStep 5: Moving test files to src/test/java/{target_package.replace('.', '/')}...")
    
    # Create target package directory
    test_package_dir = os.path.join(project_dir, "src", "test", "java", target_package.replace(".", os.sep))
    os.makedirs(test_package_dir, exist_ok=True)
    
    # Move files
    for test_file in test_files:
        src_path = os.path.join(project_dir, test_file)
        dst_path = os.path.join(test_package_dir, test_file)
        
        if os.path.exists(src_path):
            shutil.copy2(src_path, dst_path)  # Use copy2 to preserve metadata
            os.remove(src_path)  # Remove original file
            print(f"Moved {test_file} to {test_package_dir}")
    
    # Step 6: Run tests
    print("\nStep 6: Running tests...")
    for test_file in test_files:
        if test_file.endswith(".java"):
            test_class_name = test_file[:-5]  # Remove .java extension
            full_test_class = f"{target_package}.{test_class_name}"
            
            print(f"Running {test_class_name}...")
            run_command(f"mvn test -Dtest={full_test_class}", project_dir)
    
    # Step 7: Generate JaCoCo report
    print("\nStep 7: Generating JaCoCo report...")
    run_command("mvn jacoco:report", project_dir)
    
    jacoco_index = os.path.join(project_dir, "target", "site", "jacoco", "index.html")
    if os.path.exists(jacoco_index):
        print(f"\nRandoop automation completed successfully!")
        print(f"JaCoCo coverage report is available at: {jacoco_index}")
    else:
        print("\nWarning: JaCoCo report was not generated. Check Maven configuration.")

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Automate Randoop test generation with JaCoCo coverage")
    parser.add_argument("--project-dir", default=".", help="Path to the project directory (default: current directory)")
    parser.add_argument("--test-class", required=True, help="Fully qualified name of the class to test (e.g., com.parkingapp.ParkingSpace)")
    parser.add_argument("--output-limit", type=int, default=500, help="Maximum number of tests to generate")
    parser.add_argument("--package", default="randoopTestParkingApp", help="Target package for the generated tests")
    
    args = parser.parse_args()
    
    automate_randoop(args.project_dir, args.test_class, args.output_limit, args.package)