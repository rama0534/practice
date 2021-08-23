const lib = require('../lib');
const db = require('../db');
const mail = require('../mail');

describe('absolute', () => {
    it('Should return a postive number if the input is positive...', () => {
        const result = lib.absolute(1);
        expect(result).toBe(1);
    });
    
    it('Should return a negative number if the input is negative', () => {
        const result = lib.absolute(-1);
        expect(result).toBe(1);
    });
    
    it('Should return Zero if the input is zero', () => {
        const result = lib.absolute(0);
        expect(result).toBe(0);
    });
});
/* Testing Strings */
describe('greet', () => {
    it('should return the greeting message!', () =>{
        const result = lib.greet('Rama');
        expect(result).toMatch(/Rama/);
        expect(result).toContain('Rama');

    });
});
/* Array */
describe('getCurrencies', () => {
    it('should return supported curencies', () => {
        const result = lib.getCurrencies();
        // Too general 
        expect(result).toBeDefined();
        expect(result).not.toBeNull();

        //Specific
        expect(result[0]).toBe('USD');
        expect(result[1]).toBe('AUD');
        expect(result[2]).toBe('EUR');
        //Proper Way
        expect(result).toContain('USD');
        expect(result).toContain('AUD');
        expect(result).toContain('EUR');
        // Idial way 
        expect(result).toEqual(expect.arrayContaining(['AUD', 'USD', 'EUR']));
    })
})

/* Object */
describe('getProduct', () => {
    it('should return product with given ID', () => {
        const result = lib.getProduct(1);
        expect(result).toEqual({id:1, price:10});
        expect(result).toMatchObject({id:1, price: 10});
        expect(result).toHaveProperty('id', 1);
    });
});

describe('registerUser', () => {
    it('should throw if username is false', () => {
        const args = [null, undefined, NaN, '', 0, false];
        args.forEach( a => {
            expect(() => {lib.registerUser(a)}).toThrow();
        });
    });
    it('should return user object if valid user passed', () => {
        const result = lib.registerUser('Rama');
        expect(result).toMatchObject({ username: 'Rama'});
        expect(result.id).toBeGreaterThan(0);
    })
});

describe('apply Discount', () => {
    it('should applay 10% discount if customer has more than 10 points', () => {
        db.getCustomerSync = function (customerId) {
            console.log("Running fake database......");
            return { id: customerId, points: 15};
        }
        const order = { customerId: 1, totalPrice: 10};
        lib.applyDiscount(order);
        expect(order.totalPrice).toBe(9);
    });
});

describe('notifyCustomer', () => {
    it('should send an email to the customer', () => {
        db.getCustomerSync = function(customerId) {
            return { email: 'a'};
        }
        let mailSent = false;
        mail.send = function(email, message) {
            mailSent = true;
        }
        lib.notifyCustomer({ customerId: 1});
        expect(mailSent).toBe(true);
    });
});

describe('notifyCustomer', () => {
    it('should sen an email to the customer', () => {
        db.getCustomer = jest.fn().mockReturnValue({ email: 'a'});
        mail.send = jest.fn();
        lib.notifyCustomer({ customerId: 1});
        expect(mail.send).toHaveBeenCalled();
        expect(mail.send.mock.calls[0][0]).toBe('a');
        expect(mail.send.mock.calls[0][1]).toMatch(/order/);
    })
})
