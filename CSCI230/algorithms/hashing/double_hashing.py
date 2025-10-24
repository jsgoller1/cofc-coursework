def double_hash(key, i):
    return ((key % 11) + i * (5 - key % 5)) % 11


x = 78
print([
    double_hash(x, 0),
    double_hash(x, 1),
    double_hash(x, 2),
    double_hash(x, 3),
    double_hash(x, 4),
])