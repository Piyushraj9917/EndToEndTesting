@tag
Feature: Purchase the order from the Ecommerce Website

Background:
Given landed on website

@tag2
Scenario Outline: Positive scenario of submitting the order

Given Logged in the with <username> and <password>
When add <productName> to the cart
Then Checkout and Submit

Examples:
|username             | password              | productName
|Piyush@yopmail.com   | Piyush798@            | ADIDAS ORIGINAL

