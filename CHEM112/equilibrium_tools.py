import math
from collections import namedtuple

def get_reaction_quotient(reactant_concs_and_coeffs, product_concs_and_coeffs):
    """
    This function calculates K_c given either partial pressures or concentrations and 
    stoichiometric constants of each species in a reversible reaction. 

    Remember: if Q > K_c, there's more product than there would be at equilibrium, 
    so the reverse reaction is favored. When Q < K_c, we get the opposite - the forward reaction 
    is favored. 
    """
    reactants = products = 1
    for coeff, conc in reactant_concs_and_coeffs:
        reactants *= conc**coeff
    for coeff, conc in product_concs_and_coeffs:
        products *= conc**coeff
    print(products, reactants)
    return products / reactants

#reactants = [(1, 0.21), (1, 0.19)]
#products = [(1, 0.91), (1, 0.92)]
#print(get_reaction_quotient(reactants, products))

def quadratic_solver(a, b, c):
    """
    Implements the quadratic equation.
    For ax^2 + bx + c = 0, solution values for
    x are found via 
    x = (b ± sqrt(-b^2 + 4ac)) / 2a
    """
    first = (-b + math.sqrt((b**2) - (4 * a * c))) / (2*a)
    second = (-b - math.sqrt((b**2) - (4 * a * c))) / (2*a)
    return first,second

def Ka_to_pH(Ka, molarity):
    """
    For a weak acid, find the hydronium concentration via
    Ka = [H30+][HA-] / [HA]
    Then, pH = -log10([H30+]). 
    Remember:
    - The "small-x" assumption works when we're dealing with a change 
      in concentration less than 5% (0.05 = 5E-2). You need to solve the full
      quadratic formula to find change in concentration otherwise.
    - If hydronium/hydroxide concentration change is smaller than the amount contributed
      by the autoionization of water (1E-7), then you must factor that in as well. 

    """
    return -math.log(math.sqrt(Ka * molarity), 10)

def pH_to_Ka(pH, molarity):
    """
    Ka = [H3O+][HA-] / [HA] = (x)(x) / molarity-x = (10**-pH)**2 / molarity
    """
    x = (10**-pH)
    return (x)**2 / (molarity-x)

def Kb_to_pH(Kb, molarity):
    return 14 - -math.log(math.sqrt(Kb * molarity), 10)

def pKa_to_Ka(pKa):
    return 10**-pKa

def Ka_to_conj_Kb(Ka):
    return 1.01E-14 / Ka    

print(pH_to_Ka(2.48, 0.99))

# Some scratch notes
# Find K at 25C for a reaction (given), and round to 2 sig figs
# Remember that del G = - R * T * ln(K) and R is in J not kJ
# Converted to kJ / (K * mol)
# R = 0.0083145
# Temp given in C, convert to K
# T =  (273.15 + 27) 
# Table values given in kJ/mol
# G = 34.0
# K = math.e**(G / (-R * T))
# print(K) 


# Calculating reaction free energy under nonstandard conditions
# Suppose you have a reaction at 25C, and you have partial pressures of each species. Calculate
# the reaction free energy.

# Partial pressure (atm), stoichometric coefficient, and formation energy
# Species = namedtuple("Species", ['atm', 'stc', 'G'])
# reactant1 = Species(0.913, 2, -162.3)
# reactant2 = Species(3.86, 3, 0)
# product1 = Species(2.10, 2, -394.4)
# product2 = Species(5.46, 4, -228.6)

# num = product1.atm**product1.stc
# num *= product2.atm**product2.stc 
# denom = reactant1.atm**reactant1.stc
# denom *= reactant2.atm**reactant2.stc
# Q = num/denom

# G = product1.G * product1.stc
# G += product2.G * product2.stc
# G -= (reactant1.G * reactant1.stc)
# G -= (reactant2.G * reactant2.stc)
#print(G + (R * T * math.log(Q)))