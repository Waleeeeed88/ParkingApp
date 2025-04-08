#!/usr/bin/env python3
import os
import subprocess
import shutil
import re
import argparse
import platform

def run_command(command, cwd=None):
    """Run a shell command and return the output."""
    try:
        result = subprocess.run(command, shell=True, check=True, text=True,
                                stdout=subprocess.PIPE, stderr=subprocess.PIPE, cwd=cwd)
        return result.stdout
    except subprocess.CalledProcessError as e:
        print(f"Error executing command: {command}")
        print(f"Error message: {e.stderr}")
        return None

def automate_randoop(project_dir, test_class, output_limit=500):
    """
    Automate Randoop test generation and setup

    Args:
        project_dir: Path to the project directory
        test_class: Fully qualified name of the class to test (e.g., york.eecs.bt.BinaryTree)
        output_limit: Maximum number of tests to generate
    """
    # Ensure we're working with absolute path
    project_dir = os.path.abspath(project_dir)
    package_name = test_class.rsplit('.', 1)[0]
    classpath_sep = ";" if os.name == "nt" else ":"

    print(f"Starting Randoop automation for {test_class} in {project_dir}")

    # Step 1: Compile the project
    print("\nStep 1: Compiling the project...")
    run_command("mvn clean", project_dir)
    run_command("mvn compile", project_dir)

    # Step 2: Generate test cases with Randoop
    print("\nStep 2: Generating test cases with Randoop...")
    randoop_jar_path = os.path.join(project_dir, "randoop-lib", "randoop-all-4.2.1.jar")
    classpath = f"{project_dir}/target/classes/{classpath_sep}{randoop_jar_path}"
    randoop_cmd = (
        f"java -classpath \"{classpath}\" "
        f"randoop.main.Main gentests "
        f"--testclass={test_class} --output-limit={output_limit}"
    )
    run_command(randoop_cmd, project_dir)

    # Step 3: Clean temporary .class files (cross-platform)
    print("\n🧼 Step 3: Cleaning temporary .class files...")
    for file in os.listdir(project_dir):
        if file.endswith(".class"):
            try:
                os.remove(os.path.join(project_dir, file))
                print(f"Deleted: {file}")
            except Exception as e:
                print(f"Failed to delete {file}: {e}")
                
    # Step 4: Add package name to generated test files
    print("\nStep 4: Adding package name to test files...")
    package_name = test_class.rsplit('.', 1)[0]
    test_files = ["RegressionTest0.java", "ErrorTest0.java"]

    for test_file in test_files:
        if os.path.exists(os.path.join(project_dir, test_file)):
            # Read the file content
            with open(os.path.join(project_dir, test_file), 'r') as f:
                content = f.read()

            # Add package declaration at the beginning
            with open(os.path.join(project_dir, test_file), 'w') as f:
                f.write(f"package {package_name};\n\n{content}")
            print(f"Added package declaration to {test_file}")

    # Step 5: Move the files to the test directory
    print("\nStep 5: Moving test files to test directory...")
    test_package_dir = os.path.join(project_dir, "src", "test", "java", package_name.replace(".", os.sep))

    # Create the directory if it doesn't exist
    os.makedirs(test_package_dir, exist_ok=True)

    for test_file in test_files:
        src_path = os.path.join(project_dir, test_file)
        if os.path.exists(src_path):
            dst_path = os.path.join(test_package_dir, test_file)
            shutil.move(src_path, dst_path)
            print(f"Moved {test_file} to {dst_path}")

    # Step 6: Run the tests
    print("\nStep 6: Running Randoop-generated tests...")
    for test_class_name in ["RegressionTest0", "ErrorTest0"]:
        full_test_class = f"{package_name}.{test_class_name}"
        test_file_path = os.path.join(test_package_dir, f"{test_class_name}.java")

        if os.path.exists(test_file_path):
            print(f"Running {test_class_name}...")
            run_command(f"mvn test -Dtest={full_test_class}", project_dir)

    print("\nRandoop automation completed successfully!")
    print(f"Code coverage report is available at: {project_dir}/target/site/jacoco/index.html")

if __name__ == "__main__":
    import argparse

    parser = argparse.ArgumentParser(description="Automate Randoop test generation")
    parser.add_argument("--project-dir", required=True, help="Path to the project directory")
    parser.add_argument("--test-class", required=True, help="Fully qualified name of the class to test")
    parser.add_argument("--output-limit", type=int, default=500, help="Maximum number of tests to generate")

    args = parser.parse_args()

    automate_randoop(args.project_dir, args.test_class, args.output_limit)