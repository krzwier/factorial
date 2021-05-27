# Factorial

## Methodology

- TDD
    - focus on red, green, refactor
- Start small, add complexity
- Limit scope at each step
- Use any language

## Phases

### Zero - testbed

- Setup a project in your language of choice.
- Add an empty method/class/module/function.
- Add an empty test.
- Assert that true equals false. Run the test, it should fail, demonstrating that the testbed is working.

### One - function

- Create a function that returns the [factorial](https://en.wikipedia.org/wiki/Factorial) of the input provided.
- happy path behavior
    - 1! == 1
    - 2! == 2
    - 5! == 120
    - 8! == 40320
- edge case
    - 0! == 1

### Two - arbitrary precision

- The factorial function should handle very large calculations with exact precision
- Test cases
    - 10! == 3628800
    - 20! == 2432902008176640000
    - 100! == 9.3 * 10^157

### Three - input validation

- Some inputs don't make sense. Negative numbers should result in an error. No inputs above 100 should be accepted. If the language is weakly typed, non-integer inputs should not be accepted.
- Test cases
    - (-10)! == error
    - 105! == error
    - (hello)! == error
    - (3.03)! == error

### Four - webservice

- The function should be exposed as a webservice. The input will be a query parameter and the output will be in json form.
- Acceptance tests
    - GET http://localhost/api/factorial?input=5 -->> 200 {"output":"120"}
    - GET http://localhost/api/factorial?input=100 -->> 200 {"output":"93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"}
    - GET http://localhost/api/factorial?input= -->> 400
    - GET http://localhost/api/factorial?input=hello -->> 400

### Five - ui

- The webservice should be wrapped in a simple page and presented to users
- ui/ux design will be collaborative
- Controls
    - title
    - header
    - input
    - button
    - result
