
# Garments-Management-System



### **Project Overview**
The Garment Management System is a Java-based application designed to manage an inventory of garments and allow users to place orders. The system allows basic inventory management, including adding, viewing, and removing garments, as well as creating orders and updating stock.

### **Classes and Responsibilities**

1. **`Garment`**
   - Represents a garment with attributes: `name`, `size`, `color`, `quantity`, and `price`.
   - Provides methods to get garment details and update the quantity.
   - Overrides `toString` to print garment details in a readable format.

2. **`Order`**
   - Represents a customer's order and maintains a list of ordered garments.
   - Calculates and updates the total price based on the garments and quantities ordered.
   - Provides methods to add a garment to the order (checking stock availability) and to view the order summary, including the total price.

3. **`Inventory`**
   - Manages the collection of available garments.
   - Provides methods to add, remove, and search garments in the inventory.
   - Has a `viewGarments` method to display all available garments.

4. **`GarmentManagementSystem`**
   - The main class that contains the application logic.
   - Provides a menu-driven interface for the user to interact with the system, including:
     - Adding a garment to the inventory.
     - Removing a garment from the inventory.
     - Viewing all garments in the inventory.
     - Creating an order by selecting garments and specifying quantities.
   - Uses a loop to display the menu until the user chooses to exit.

### **Features**

- **Add Garment**: Allows users to input details like name, size, color, quantity, and price, then adds the garment to the inventory.
- **Remove Garment**: Allows users to remove a garment from the inventory by name.
- **View Garments**: Displays all garments currently available in the inventory.
- **Create Order**: Allows users to place an order by selecting garments and specifying quantities. Updates stock levels and calculates the total order price.
- **Exit**: Exits the application.

### **Usage Flow**
1. User launches the application and sees a menu with options to add, remove, view garments, or create an order.
2. Selecting an option leads to a prompt for the necessary input, with the system providing feedback or displaying results as appropriate.
3. Users can view the order details, which includes the total price.
4. The application runs in a loop until the user chooses to exit.

### **Example Scenarios**
- A store manager adds a list of new garments to the inventory.
- A customer places an order for garments, and the system automatically checks stock, updates quantities, and calculates the total price.
- The manager removes items that are out of stock or discontinued.

### **Potential Enhancements**
In future versions, consider adding:
- **Persistent Storage**: Use a database to store garments and orders permanently.
- **User Authentication**: Implement roles (e.g., admin, customer).
- **Improved Order Management**: Allow multiple garments per order and enhanced viewing capabilities.

This project provides a foundational structure for a garment management system and could be expanded with additional functionalities for larger-scale applications.
