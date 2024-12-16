# Coffee Machine Project

This project simulates a simple coffee machine using Java. The machine tracks its resources (water, milk, coffee beans, disposable cups, and cash) and allows the user to perform various actions, including buying coffee, refilling resources, collecting money, and cleaning the machine. It is structured using object-oriented principles for better code organization and extensibility.

## Features

- **Buy Coffee**:
  - Three types of coffee: Espresso, Latte, and Cappuccino.
  - Each coffee type requires specific amounts of water, milk, coffee beans, and cups.
  - Checks if sufficient resources are available to make the chosen coffee.
  - Updates the machine's state after making coffee.
- **Refill Resources**:
  - Add water, milk, coffee beans, and disposable cups to the machine.
- **Collect Money**:
  - Collect all the cash from the machine.
- **Cleaning**:
  - The machine requires cleaning after making 10 cups of coffee.
  - Users can clean the machine to reset its cleaning status.
- **Display Remaining Resources**:
  - View the current state of the machine, including available resources and money.
- **Exit**:
  - Exit the simulation.

## Coffee Types and Requirements

| Coffee Type   | Water (ml) | Milk (ml) | Coffee Beans (g) | Cost ($) |
|---------------|------------|-----------|------------------|----------|
| Espresso      | 250        | 0         | 16               | 4        |
| Latte         | 350        | 75        | 20               | 7        |
| Cappuccino    | 200        | 100       | 12               | 6        |

## Code Structure

### `Coffee` Class
Represents a type of coffee. Each instance stores:
- Required water.
- Required milk.
- Required coffee beans.
- Cost.

### `CoffeeMachine` Class
Manages the coffee machine's state and handles user actions:
- Tracks resources: water, milk, coffee beans, disposable cups, and money.
- Tracks the cleaning requirement after making 10 cups of coffee.
- Implements methods for each user action:
  - `buyCoffee`
  - `fillMachine`
  - `takeMoney`
  - `cleanMachine`
  - `displayState`

### `Main` Class
- Provides the main loop to process user input.
- Interacts with the `CoffeeMachine` to perform actions.

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/AbWaris7/Coffee-Machine-Simulator.git
   ```

2. Compile the program:
   ```bash
   javac Main.java
   ```

3. Run the program:
   ```bash
   java Main
   ```

4. Follow the prompts to interact with the coffee machine:
   - Type `buy`, `fill`, `take`, `clean`, `remaining`, or `exit` to perform actions.

## Example Interaction

```
Write action (buy, fill, take, clean, remaining, exit):
buy
What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
1
I have enough resources, making you a coffee!

Write action (buy, fill, take, clean, remaining, exit):
remaining
The coffee machine has:
150 ml of water
540 ml of milk
104 g of coffee beans
8 disposable cups
$554 of money

Write action (buy, fill, take, clean, remaining, exit):
exit
```

## Future Improvements

- Add support for custom coffee recipes.
- Implement a graphical user interface (GUI).
- Add persistence to save and load the machine's state.

## License

This project is open-source and available under the MIT License.

