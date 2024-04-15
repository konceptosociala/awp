# Solving the main tasks

Tasks Solvation:

1. **Implement a Graphical User Interface (GUI)**:
    * Develop a user-friendly GUI using own Swelm UI framework, providing intuitive navigation and interaction for users.

2. **Save Data to File/Files**:
    * Implement data serialization to save product groups and products to JSON file.

3. **Unique Product and Group Names**:
    * Ensure uniqueness of product names and product group names to prevent duplication and maintain data integrity.
    * Use "Newtype" paradigm to ensure safety and types validation

4. **Group Management (Add/Edit/Delete)**:
    * Implement functionality to add, edit, and delete product groups.
    * Upon deletion of a product group, remove all associated products.
    * Use HashSets to store data

5. **Product Management (Add/Edit/Delete)**:
    * Enable users to add, edit, and delete products within product groups, providing options to modify attributes such as name, description, manufacturer, and price per unit.
    * Use HashSets to store data

6. **Product Search**:
    * Develop a search feature enabling users to search for products based on various criteria such as name, description, or manufacturer.
    * Use regular expressions to perform fast and errorless search

7. **Statistical Data Output**:
    * Provide functionality to output statistical data, including:
        * List of all products with warehouse information.
        * List of all products by product group with details.
        * Calculation of total cost of goods in stock (quantity * unit price).
        * Calculation of total cost of goods in a specific product group.

