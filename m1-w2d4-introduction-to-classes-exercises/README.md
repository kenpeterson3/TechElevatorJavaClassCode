# Introduction to Classes  Exercises

The following are descriptions of everyday items that you need to implement as classes. The set of attributes and methods are outlined for each item.

## *Easier Exercises*
## Company

### Data Members

| Attribute | Data Type | Get | Set | Description |
|----------|-----------|-----|-----|-------------|
| name | string | X | X | The company name. |
| numberOfEmployees | int | X | X | The number of employees at the company. |
| revenue | double | X | X | The annual revenue of the company. |
| expenses | double | X | X | The annual expenses of the company. |

### Methods

    public String getCompanySize()
    public double getProfit()

**Notes**
- `getCompanySize()` returns "small" if 50 or less employees, "medium" if between 51 and 250 employees, "large" if greater than 250 employees.
- `getProfit()` returns the result of revenue - expenses.

### Constructor

The `Company` class uses the default constructor.

## Person

### Data Members

| Attribute | Data Type | Get | Set | Description |
|----------|-----------|-----|-----|-------------|
| firstName | String | X | X | The first name of the person.  |
| lastName | String | X | X | The last name of the person. |
| age | int | X | X | The age of the person. |

### Methods

    public String getFullName()
    public boolean isAdult()

**Notes**
- `getFullName()` returns the `lastName` + ", " + `firstName`.
- `isAdult()` returns `true` if the person is 18 or older.

### Constructors

The `Person` class uses the default constructor.

## Product

### Data Members

| Attribute | Data Type | Get | Set | Description |
|----------|-----------|-----|-----|-------------|
| name | String | X | X | The name of the product.  |
| price | double | X | X | The price of the product. |
| weightInOunces | double | X | X | The weight (in ounces) of the product. |

### Methods

**Notes**
- There are no additional methods beyond the basic getters and setters.

### Constructors

The `Product` uses the default constructor.

## *Medium Exercises*
## Dog

### Data Members

| Attribute | Data Type | Get | Set | Description |
|----------|-----------|-----|-----|-------------|
| sleeping | boolean | X | | `TRUE` if the dog is asleep. `FALSE` if not.   |

**Notes**
- All new dogs are awake by default.

### Methods

    public String makeSound()
    public void sleep()
    public void wakeUp()

**Notes**
- `makeSound()` returns `"Zzzzz..."` if the dog is asleep. Returns `"Woof!"` if the dog is awake.
- `sleep()` sets `sleeping` to `true`.
- `wakeUp()` sets `sleeping` to `false`.

### Constructor

The `Dog` class uses the default constructor.

## ShoppingCart

### Data Members

| Attribute | Data Type | Get | Set | Description |
|----------|-----------|-----|-----|-------------|
| totalNumberOfItems | int | X | X | The number of items in the shopping cart.  |
| totalAmountOwed | double | X | X | The total amount owed. |

**Notes**
- All shopping carts have total 0 items and 0.0 amount owed by default.

### Methods

    public double getAveragePricePerItem()
    public void addItems(int numberOfItems, double pricePerItem)
    public void empty()

**Notes**
- `getAveragePricePerItem()` returns the result of `totalAmountOwed / totalNumberOfItems`.
- `addItems(int numberOfItems, double pricePerItem)` updates `totalNumberOfItems` and increases `totalAmountOwed` by `(pricePerItem * numberOfItems)`
- `empty()` resets `totalNumberOfItems` to 0 and `totalAmountOwed` to 0.0.

### Constructor

The `ShoppingCart` class uses the default constructor.

## *Difficult Exercises*
## Calculator

### Data Members

| Attribute | Data Type | Get | Set | Description |
|----------|-----------|-----|-----|-------------|
| currentValue | int | X |  | The current calculated value. |

**Notes**
- All calculators have 0 as currentValue by default.

### Methods

    public int add(int addend)
    public int multiply(int multiplier)
    public int subtract(int subtrahend)
    public int power(int exponent)
    public void reset()

**Notes**
- `add(int addend)` returns the new `currentValue` after performing the addition.
- `multiply(int multiplier)` returns the new `currentValue` after performing the multiplication.
- `subtract(int subtrahend)` returns the new `currentValue` after performing the subtraction.
- `power(int exponent)` returns the new `currentValue` after raising the `currentValue` by the exponent.
- `void reset()` resets the `currentValue` to 0.

### Constructor

The `Calculator` class uses the default constructor.
