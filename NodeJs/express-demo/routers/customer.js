const express = require('express');
const router = express.Router();
const { Customer, validateCustomer } = require('../models/customer')

router.get('/', async(req, res) => {
    try{
        const customers = await Customer.find();
        res.send(customers);
    }
    catch(err){
        console.log('Error while getting customer data', err);
    }
});
router.get('/:id', async(req, res) => {
    try{
        const customer = await Customer.findById({_id:req.params.id});
        if(!customer) return res.status(400).send(`The requested genre with given   ${req.params.id} was not found.`);
        res.send(customer);

    }
    catch(err){
        console.log(`Error Occured while getting ${req.params.id}`, err)
    }
});
router.post('/', async(req, res) => {
    try{
        const result = validateCustomer(req.body);
        if(result.error) return res.status(400).send(result.error.details[0].message);
        let customer = new Customer ({ 
                                        isGold: req.body.isGold,
                                        name: req.body.name,
                                        phone: req.body.phone
                                     })
        customer = await customer.save();
        res.send(customer);
    }
    catch(err){
        console.log("Error while posting the data", err);
    }
});
router.put('/:id', async(req, res) => {
    try{
        const result = validateCustomer(req.body);
        if(result.error) return res.status(400).send(result.error.details[0].message);
        const customer = await Customer.findByIdAndUpdate(req.params.id,{
                                        isGold: req.body.isGold,
                                        name: req.body.name,
                                        phone: req.body.phone}, {new: true});
        if(!customer) return res.status(400).send(`The customer with given ID ${req.params.id} was not found`);
        res.send(customer);
    }
    catch(err){
        console.log("Error occured while updating")
    }
});
router.delete('/:id', async(req, res) => {
    try{
        const result = await Customer.findByIdAndDelete(req.params.id);
        if(!result) return res.status(400).send(`The custoemr with the given ID ${req.parama.id} was not found`);
        res.send(result);
    }
    catch{
        console.log(`Error occured while deleting ${req.params.id}`, err)
    }
})
module.exports = router;

