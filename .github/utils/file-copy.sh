#!/bin/bash

# Define the source file and folder
source_folder="1"
file_to_copy="frontend-sonar.yml"

# Loop through folders 2 to 20 and copy the file
for ((i = 2; i <= 20; i++)); do
    destination_folder="$i"

    # remove the file if it exists
    if [ -f "$destination_folder/$file_to_copy" ]; then
        rm "$destination_folder/$file_to_copy"
    fi
    # copy the file and add it to git
    cp "$source_folder/$file_to_copy" "$destination_folder/"
    git add "$destination_folder/$file_to_copy"
done

echo "File copied to all folders."
