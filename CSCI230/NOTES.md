# Notes

## Pre/post/infix notations
Prefix to postfix and vice versa are just string reversal. Infix to either or vice versa is trickier.

`A + B * (C - D)` to prefix: `* + A B - C D`

`(A + B) * (C - D / E)` to prefix: `* + A B - C / D E`; also valid is