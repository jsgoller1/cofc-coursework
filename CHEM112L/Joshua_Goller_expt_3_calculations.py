import math

# 1-6: Got these initially by hand in my notebook
concs = {
    "8.6": {
        "[H30]": 2.511e-9,
        "[IN-]": 7.8498e-6,
    },
    "8.8": {
        "[H30]": 1.584e-9,
        "[IN-]": 1.0238e-5,
    },
    "9.0": {
        "[H30]": 1.000e-9,
        "[IN-]": 2.25e-5,
    },
    "9.2": {
        "[H30]": 6.309e-10,
        "[IN-]": 3.6177e-5,
    },
    "UNK A": {
        "[IN-]": 2.9573e-5
    },
}

# 7, 8: Calculate [HIn] for each solution
indicator_data = [("8.6", 7.8498e-6), ("8.8", 1.0238e-5), ("9.0", 2.25e-5), ("9.2", 3.6177e-5), ("UNK A", 2.9573e-5)]
for ph, conc in indicator_data:
     concs[ph]["[HIN]"] = round(3.14e-4 - conc, 5)

# 9: Calculating K_c for solution
for k,v in concs.items():
    if k != "UNK A":
        concs[k]["K_c"] = v["[H30]"] * (v["[IN-]"]/v["[HIN]"])
    print(f"{k}: {concs[k]}")

# 10: Averaged K_c
n = 0
total = 0
for k, v in concs.items():
    if "K_c" in v:
        total += v["K_c"]
        n += 1
avg_K_c = (total / n)
print(f"Average K_c: {avg_K_c} ")
print(f"pH of unknown A: {-math.log(avg_K_c * (concs["UNK A"]["[HIN]"]/concs["UNK A"]["[IN-]"]) , 10)}")