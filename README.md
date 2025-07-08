# Quantum Bookstore

Quantum Bookstore is a simple inventory and purchase management system designed to handle different types of books (e.g., PDF, Paper, Audiobook, Comic) with flexible purchase behaviors depending on the book type.

---

## Features

- Manage books inventory with quantities.
- Support multiple book types with type-specific purchase handling.
- Customers can checkout books, and the system validates purchase details.
- Extensible design allows adding new book types easily without modifying core logic.
- Remove outdated books from inventory based on age.
- Error handling for invalid purchases like insufficient stock, invalid emails, or unknown book types.

---

## Key Principles and Design

### 1. Separation of Concerns  
The system separates responsibilities into distinct classes:

- **Inventory**: Manages stock and purchase transactions.
- **Book**: Contains book information and delegates purchase actions.
- **BookTypeRegistry**: Registers and manages different purchase handlers for book types.
- **Customer**: Represents a buyer interacting with the inventory.

This improves **maintainability** and **clarity**.

### 2. Extensibility  
Adding a new book type is easy — just register a new handler in `BookTypeRegistry` with the purchase message format and logic, without changing other parts of the system.

### 3. Robust Validation and Error Handling  
Checks for valid quantities, emails, addresses, and stock availability ensure the system behaves correctly and safely.

---

## Usage

1. Register book types and their handlers via `BookTypeRegistry`.
2. Add books to the inventory.
3. Create customers and use their `checkout()` method to buy books.
4. Handle exceptions for invalid operations gracefully.

---

## Example Test Cases

- Buying digital (PDF) and physical (paper) books.
- Attempting to buy with invalid email or empty shipping address.
- Buying more copies than available.
- Trying to buy a book with an unknown type.
- Removing outdated books based on publishing year.

---
👨‍💼 Author Youssef Ahmed Computer Science Student | Offensive Security Engineer | Web3 Developer

---

📜 License MIT License — This project is licensed for educational and personal use only.
