Absolutely. Below is a **fresh, complete AMVI-oriented note for Specific Gravity**, incorporating the **standard/reference fluids for liquids, solids, and gases** along with formulas, units, temperature/pressure effects, numerical examples, MCQ traps, and revision points.

# Specific Gravity — AMVI Notes

## 1. Definition

**Specific Gravity (SG)** is the ratio of the density of a substance to the density of a reference substance under specified/reference conditions.

For liquids and solids, the reference is conventionally **water at 4°C**.

For gases, the reference is commonly **air at the same temperature and pressure**.

---

## 2. Reference Standard for Specific Gravity

This is an important AMVI point.

| Substance being tested | Reference substance | Reference condition           |
| ---------------------- | ------------------- | ----------------------------- |
| **Liquid**             | Water               | Conventionally water at 4°C   |
| **Solid**              | Water               | Conventionally water at 4°C   |
| **Gas**                | Air                 | Same temperature and pressure |

### 🧠 Memory Trick

> **Liquid → Water**
> **Solid → Water**
> **Gas → Air**

---

# 3. Specific Gravity of Liquids and Solids

For a liquid or solid:

```math
SG = \frac{\rho_{substance}}{\rho_{water}}
```

More precisely, with the conventional water reference:

```math
SG = \frac{\rho_{substance}}{\rho_{water\ at\ 4^\circ C}}
```

Approximately:

```text
ρwater ≈ 1000 kg/m³
```

Therefore, for many AMVI numerical problems:

```math
SG \approx \frac{\rho_{substance}}{1000}
```

---

# 4. Why Water at 4°C?

Water has approximately its **maximum density at 4°C**.

```text
ρwater ≈ 1000 kg/m³
```

Therefore, water at 4°C is conventionally used as the reference for specific gravity of liquids and solids.

### AMVI MCQ

**The conventional reference substance for specific gravity of liquids is:**

A. Air
B. Mercury
C. Water at 4°C
D. Oil

**Answer: C — Water at 4°C** ✅

---

# 5. Specific Gravity of Gases

For gases, the commonly used reference is **air**.

```math
SG_{gas} =
\frac{\rho_{gas}}
{\rho_{air}}
```

The comparison is normally made at the **same temperature and pressure**.

### Important

> **Gas SG = density of gas / density of air at the same T and P**

---

## Example

Suppose:

```text
Density of gas = 1.8 kg/m³
Density of air = 1.2 kg/m³
```

Then:

```math
SG_{gas} = \frac{1.8}{1.2}
```

```text
SGgas = 1.5
```

Therefore, the gas is **1.5 times as dense as air** under those conditions.

---

# 6. Specific Gravity is Dimensionless

Specific gravity is a ratio:

```math
SG = \frac{\rho_{substance}}{\rho_{reference}}
```

Therefore, units cancel:

```math
SG =
\frac{kg/m^3}{kg/m^3}
```

Hence:

```text
SG = dimensionless
```

### Important

Specific gravity has:

* **No SI unit**
* **No dimensions**

---

# 7. Relationship Between SG and Density

For liquids/solids:

```math
SG = \frac{\rho}{\rho_{water}}
```

Therefore:

```math
\rho = SG \times \rho_{water}
```

If:

```text
ρwater ≈ 1000 kg/m³
```

then:

```math
\rho \approx SG \times 1000
```

---

## Example

A liquid has:

```text
SG = 0.8
```

Find density.

```math
\rho = SG \times \rho_{water}
```

```math
\rho = 0.8 \times 1000
```

```text
ρ = 800 kg/m³
```

### Answer

**Density = 800 kg/m³**

---

# 8. Meaning of SG < 1, SG = 1 and SG > 1

This is very important for AMVI.

### SG < 1

```text
Density of substance < Density of water
```

Example:

```text
SG = 0.8
```

Then:

```text
ρ = 800 kg/m³
```

---

### SG = 1

```text
Density of substance = Density of water
```

Example:

```text
SGwater ≈ 1
```

---

### SG > 1

```text
Density of substance > Density of water
```

Example:

```text
SG = 13.6
```

Then:

```math
\rho = 13.6 \times 1000
```

```text
ρ ≈ 13600 kg/m³
```

This is approximately the density of mercury.

---

# 9. Specific Gravity and Specific Weight

You already learned:

```math
\gamma = \rho g
```

Specific gravity can also be expressed using specific weight.

```math
SG =
\frac{\gamma_{substance}}
{\gamma_{water}}
```

### Why?

Because:

```math
\gamma_{substance} = \rho_{substance}g
```

and:

```math
\gamma_{water} = \rho_{water}g
```

Therefore:

```math
SG =
\frac{\rho_{substance}g}
{\rho_{water}g}
```

`g` cancels:

```math
SG =
\frac{\rho_{substance}}
{\rho_{water}}
```

### ⭐ AMVI Formula

```math
SG = \frac{\gamma_{substance}}{\gamma_{water}}
```

---

# 10. Example Using Specific Weight

A liquid has specific gravity `0.75`. Find its specific weight.

For water:

```text
γwater ≈ 9.81 kN/m³
```

Using:

```math
\gamma_{fluid} = SG \times \gamma_{water}
```

```math
\gamma_{fluid} = 0.75 \times 9.81
```

```text
γfluid = 7.3575 kN/m³
```

Therefore:

**Specific weight ≈ 7.36 kN/m³**

---

# 11. Specific Gravity and Specific Volume

You know:

```math
v = \frac{1}{\rho}
```

Therefore:

```math
\rho = \frac{1}{v}
```

For the substance:

```math
SG =
\frac{1/v_{substance}}
{1/v_{water}}
```

Therefore:

```math
SG =
\frac{v_{water}}
{v_{substance}}
```

### ⭐ Formula

```math
SG = \frac{v_{water}}{v_{substance}}
```

---

# 12. Relationship Among Fluid Properties

These four properties are closely related:

```text
                    DENSITY
                       ρ
                    /     \
                   /       \
                  ↓         ↓
       Specific Volume   Specific Weight
              v                γ
            1/ρ               ρg
                               │
                               ↓
                       Specific Gravity
                               SG
                         ρ/ρwater
```

### Important formulas

```math
\rho = \frac{m}{V}
```

```math
v = \frac{1}{\rho}
```

```math
\gamma = \rho g
```

```math
SG = \frac{\rho}{\rho_{water}}
```

---

# 13. Does Specific Gravity Depend on Gravity?

### No — not directly. ✅

Specific gravity:

```math
SG = \frac{\rho_{fluid}}{\rho_{water}}
```

There is no `g` in this expression.

Even if gravitational acceleration changes from one location to another, if the densities remain unchanged:

```text
SG remains unchanged
```

This is different from specific weight.

### Specific weight

```math
\gamma = \rho g
```

Therefore:

```text
g changes → γ changes
```

### Specific gravity

```math
SG = ρfluid / ρwater
```

Therefore:

```text
g changes → SG does not directly change
```

### 🔥 AMVI MCQ

**Which property is independent of gravitational acceleration?**

Specific gravity. ✅

---

# 14. Effect of Temperature on Specific Gravity

This needs careful understanding.

Specific gravity is:

```math
SG =
\frac{\rho_{fluid}}
{\rho_{reference}}
```

Temperature can change density.

Therefore:

> **Specific gravity can change with temperature.**

---

## For most liquids

As temperature increases:

```text
Temperature ↑
      ↓
Volume ↑
      ↓
Density ↓
```

If the reference water density is treated as fixed:

```text
Density ↓
     ↓
SG ↓
```

Therefore, for many ordinary liquid comparisons:

> **Temperature ↑ → SG ↓**

---

# 15. Water — Special Case

Water behaves unusually between 0°C and 4°C.

Water has approximately maximum density at:

**4°C**

Therefore:

```text
At 4°C:

Density → maximum
Specific volume → minimum
Specific weight → maximum
```

If water is being considered as the substance itself:

```text
SGwater ≈ 1
```

at the reference condition.

### AMVI Trap

Do not simply memorize:

> "Temperature increase always decreases SG."

❌ Too general.

You must consider how temperature changes the density of both the substance and the reference.

---

# 16. Effect of Pressure on Specific Gravity

For liquids:

```text
Pressure ↑
    ↓
Density ↑ slightly
    ↓
SG changes slightly
```

Because liquids are only slightly compressible.

For engineering calculations, liquids are often treated as incompressible:

```text
ρ ≈ constant
```

Therefore:

```text
SG ≈ constant
```

with pressure.

### AMVI answer

> **For an incompressible liquid, specific gravity is approximately independent of pressure.**

---

# 17. Gases — Effect of Pressure on SG

For an ideal gas:

```math
\rho = \frac{PM}{RT}
```

At constant temperature:

```math
\rho \propto P
```

Therefore gas density changes significantly with pressure.

However, gas SG is normally defined relative to **air at the same temperature and pressure**:

```math
SG_{gas} =
\frac{\rho_{gas}}
{\rho_{air}}
```

For ideal gases:

```math
\rho = \frac{PM}{RT}
```

For gas and air at the same `P` and `T`:

```math
SG_{gas}
=
\frac{M_{gas}}{M_{air}}
```

Therefore:

> **For ideal gases at the same temperature and pressure, gas SG depends primarily on molecular mass ratio.**

---

# 18. Gas Specific Gravity and Molecular Mass

Molecular mass of air:

```text
Mair ≈ 28.97 kg/kmol
```

Therefore:

```math
SG_{gas}
\approx
\frac{M_{gas}}{28.97}
```

---

## Example: Oxygen

Molecular mass:

```text
MO₂ = 32 kg/kmol
```

Therefore:

```math
SG_{O_2}
=
\frac{32}{28.97}
```

```text
SGO₂ ≈ 1.10
```

So oxygen is approximately **1.10 times as dense as air** at the same temperature and pressure.

---

# 19. Some Approximate Specific Gravities

| Substance               | Approx. SG | Reference |
| ----------------------- | ---------: | --------- |
| Water                   |       1.00 | Water     |
| Kerosene                |       ~0.8 | Water     |
| Typical lubricating oil | ~0.85–0.90 | Water     |
| Mercury                 |      ~13.6 | Water     |
| Seawater                |     ~1.025 | Water     |
| Air                     |        1.0 | Air       |
| Oxygen                  |      ~1.10 | Air       |
| Hydrogen                |      ~0.07 | Air       |

These are approximate values; actual values depend on temperature, pressure, composition, and reference conditions.

---

# 20. Specific Gravity and Floating/Sinking

For an object placed in water, its **average density** relative to water is important.

### If:

```math
SG < 1
```

Average density is less than water.

→ **Tendency to float**

### If:

```math
SG > 1
```

Average density is greater than water.

→ **Tendency to sink**

### If:

```math
SG = 1
```

Average density equals water.

→ **Neutral buoyancy when fully submerged**, under idealized conditions.

### 🧠 Memory

```text
SG < 1 → Less dense → Float tendency
SG = 1 → Same density
SG > 1 → More dense → Sink tendency
```

---

# 21. Important AMVI Numerical Formulas

### Density from SG

```math
\rho = SG \times \rho_{water}
```

### Specific weight from SG

```math
\gamma = SG \times \gamma_{water}
```

### SG from density

```math
SG = \frac{\rho}{\rho_{water}}
```

### SG from specific weight

```math
SG = \frac{\gamma}{\gamma_{water}}
```

### SG from specific volume

```math
SG = \frac{v_{water}}{v}
```

### Gas SG

```math
SG_{gas} = \frac{\rho_{gas}}{\rho_{air}}
```

For ideal gases at same `T` and `P`:

```math
SG_{gas} = \frac{M_{gas}}{M_{air}}
```

---

# 🔥 AMVI MCQ Practice

### Q1. Specific gravity is the ratio of:

A. Mass to volume
B. Weight to volume
C. Density of substance to density of reference substance
D. Volume to mass

**Answer: C** ✅

---

### Q2. Conventional reference fluid for specific gravity of liquids is:

A. Air
B. Water at 4°C
C. Mercury
D. Oil

**Answer: B** ✅

---

### Q3. Reference gas commonly used for gas specific gravity is:

A. Hydrogen
B. Oxygen
C. Nitrogen
D. Air

**Answer: D** ✅

---

### Q4. Gas specific gravity is normally determined relative to air at:

A. Same temperature only
B. Same pressure only
C. Same temperature and pressure
D. Zero pressure

**Answer: C** ✅

---

### Q5. Specific gravity is:

A. Dimensionless
B. kg/m³
C. N/m³
D. m³/kg

**Answer: A** ✅

---

### Q6. A liquid has SG = 0.8. Its approximate density is:

A. 80 kg/m³
B. 800 kg/m³
C. 1000 kg/m³
D. 1250 kg/m³

**Answer: B** ✅

---

### Q7. A liquid has SG = 1.2. Its approximate density is:

A. 120 kg/m³
B. 833 kg/m³
C. 1200 kg/m³
D. 1000 kg/m³

**Answer: C** ✅

---

### Q8. A fluid has SG = 13.6. It is approximately:

A. Water
B. Kerosene
C. Mercury
D. Air

**Answer: C** ✅

---

### Q9. If the gravitational acceleration changes but densities remain unchanged, specific gravity:

A. Increases
B. Decreases
C. Remains unchanged
D. Becomes zero

**Answer: C** ✅

---

### Q10. For an incompressible liquid, pressure increase causes SG to:

A. Increase significantly
B. Decrease significantly
C. Remain approximately constant
D. Become zero

**Answer: C** ✅

---

### Q11. Specific gravity in terms of specific weight is:

A. `γwater/γfluid`
B. `γfluid/γwater`
C. `γfluid × γwater`
D. `γfluid + γwater`

**Answer: B** ✅

---

### Q12. For an ideal gas at the same temperature and pressure, gas SG is approximately equal to:

A. `Mair/Mgas`
B. `Mgas/Mair`
C. `Mgas × Mair`
D. `Mgas + Mair`

**Answer: B** ✅

---

### Q13. Specific gravity of oxygen is approximately:

A. 0.07
B. 0.5
C. 1.10
D. 13.6

**Answer: C** ✅

---

# ⚠️ Most Important AMVI Traps

### Trap 1 — SG vs Density

```text
Density → kg/m³
SG → dimensionless
```

---

### Trap 2 — SG vs Specific Weight

```text
Specific weight → γ = ρg → N/m³
Specific gravity → density ratio → dimensionless
```

---

### Trap 3 — Gravity

Specific weight changes with `g`:

```math
\gamma = \rho g
```

But SG does not directly depend on `g`:

```math
SG = \frac{\rho}{\rho_{water}}
```

---

### Trap 4 — Reference Substance

```text
Liquid → Water
Solid → Water
Gas → Air
```

---

### Trap 5 — Gas Reference Conditions

For gas SG:

> **Air at the same temperature and pressure** is the usual reference.

---

### Trap 6 — SG < 1

It means:

```text
Density < water
```

It does **not** mean density is `1 kg/m³` or `0.8 kg/m³`.

---

### Trap 7 — Temperature

Specific gravity is dimensionless, but its numerical value **can change with temperature** because densities change.

---

# 🧠 One-Minute Revision

```text
                 SPECIFIC GRAVITY
                        │
                        ↓
                Ratio of densities
                        │
             ┌──────────┴──────────┐
             ↓                     ↓
       Liquid / Solid              Gas
             │                     │
          Water                  Air
        (4°C convention)       (same T & P)
             │                     │
             ↓                     ↓
      SG = ρ/ρwater          SG = ρgas/ρair
```

### ⭐ Core formulas

```math
SG = \frac{\rho_{fluid}}{\rho_{water}}
```

```math
\rho_{fluid} = SG \times \rho_{water}
```

```math
SG = \frac{\gamma_{fluid}}{\gamma_{water}}
```

```math
SG = \frac{v_{water}}{v_{fluid}}
```

For gases:

```math
SG_{gas} = \frac{\rho_{gas}}{\rho_{air}}
```

For ideal gases at the same `T` and `P`:

```math
SG_{gas} = \frac{M_{gas}}{M_{air}}
```

### 🔥 Final AMVI memory line

> **Specific Gravity = "How dense compared with the reference?"**

```text
Liquid/Solid → compared with Water
Gas          → compared with Air
SG < 1       → less dense than water
SG = 1       → same density as water
SG > 1       → more dense than water
SG            → dimensionless
g changes    → SG unchanged directly
```
