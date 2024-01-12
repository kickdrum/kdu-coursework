csv_file="$1"

while IFS=',' read -r display_name email password 
do
    # Assuming a CSV with three columns; adjust as needed
    echo "Column 1: $display_name"
    echo "Column 2: $email"
    echo "Column 3: $password"
    echo "--------"

    result = $(az ad user create --display-name "$display_name" --password "$password" --user-principal-name "$email")

    echo "$result"

done < "$csv_file"