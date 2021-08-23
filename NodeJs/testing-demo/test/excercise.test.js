const excercise = require('../exercise1');

describe('excercise', () => {
    it('should throw an error if input is not a nubmer', () => {
        expect(() => {excercise.fizzBuzz('a')}).toThrow();
        expect(() => {excercise.fizzBuzz('')}).toThrow();
        expect(() => {excercise.fizzBuzz(undefined)}).toThrow();
    });
    it('should return FizzBuzz if the input is divisible by 3 and 5', () => {
        const result = excercise.fizzBuzz(15);
        expect(result).toBe('FizzBuzz');
        expect(() => {excercise.fizzBuzz('a')}).toThrow();
    });
    it('shouel return Fizz if the input is divisible by 3', () => {
        const result = excercise.fizzBuzz(3);
        expect(result).toBe("Fizz");
    });
    it('shold return Buzz if the input is divisible by 5', () => {
        const result = excercise.fizzBuzz(5);
        expect(result).toBe("Buzz");
    })
})
