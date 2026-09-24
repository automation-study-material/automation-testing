Yes. From now on, I’ll give you **combined notes for each topic**—first the complete concept, then temperature/pressure/other effects, followed by AMVI points and MCQs.

Below are the **complete combined notes for Topic 1.3 – Density**.

# 1.3 Density

## 1.3.1 Definition

**Density** is the **mass contained in unit volume of a fluid**.

In simple words:

> Density tells us how much mass is packed into a given volume.

Formula:

```math
\rho = \frac{m}{V}
```

Where:

* `ρ` = Density
* `m` = Mass of fluid
* `V` = Volume occupied by fluid

---

## 1.3.2 Physical Meaning of Density

Suppose we have **1 litre of water** and **1 litre of oil**.

Both have the same volume, but their masses are different.

Approximately:

| Fluid | Volume | Approx. Mass |
| ----- | -----: | -----------: |
| Water |    1 L |         1 kg |
| Oil   |    1 L |   0.8–0.9 kg |

Therefore, water has greater density.

### Important concept

> For the **same volume**, a fluid having greater mass has greater density.

---

## 1.3.3 Basic Formula

```math
\rho = \frac{m}{V}
```

From this:

### Mass

```math
m = \rho V
```

### Volume

```math
V = \frac{m}{\rho}
```

These three formulas are important for numerical problems.

---

# 1.3.4 Parameters

### `ρ` — Density

Amount of mass present per unit volume.

### `m` — Mass

Quantity of matter present.

SI unit:

```text
kg
```

### `V` — Volume

Space occupied by the fluid.

SI unit:

```text
m³
```

---

# 1.3.5 SI Unit of Density

From:

```math
\rho = \frac{m}{V}
```

Therefore:

```math
[\rho] = \frac{kg}{m^3}
```

### SI unit:

**kg/m³**

---

# 1.3.6 Other Units

Density can also be expressed as:

* kg/m³
* g/cm³
* g/mL
* kg/L

Important conversion:

```text
1 g/cm³ = 1000 kg/m³
```

Therefore:

```text
1 kg/m³ = 0.001 g/cm³
```

### Example

Density of water:

```text
1000 kg/m³
```

is equivalent to:

```text
1 g/cm³
```

---

# 1.3.7 Dimensions of Density

We know:

```math
\rho = \frac{m}{V}
```

Dimensions of mass:

```text
[M]
```

Dimensions of volume:

```text
[L³]
```

Therefore:

```math
[\rho] = \frac{M}{L^3}
```

### Dimensional formula:

```text
[M L⁻³]
```

### AMVI ⭐

> Density has dimensional formula **ML⁻³**.

---

# 1.3.8 Density of Water

For most engineering calculations:

```text
ρwater ≈ 1000 kg/m³
```

or:

```text
ρwater ≈ 1 g/cm³
```

This value is very important in fluid mechanics.

---

# 1.3.9 Density of Some Common Fluids

Approximate values:

| Fluid    |        Density |
| -------- | -------------: |
| Air      |      1.2 kg/m³ |
| Petrol   | ~700–750 kg/m³ |
| Kerosene |     ~800 kg/m³ |
| Oil      | ~800–900 kg/m³ |
| Water    |    ~1000 kg/m³ |
| Mercury  |  ~13,600 kg/m³ |

Hence approximately:

```text
Mercury > Water > Oil/Kerosene > Air
```

in terms of density.

---

# 1.3.10 Density vs Mass

These are different quantities.

### Mass

Tells us:

> How much matter is present?

Unit:

```text
kg
```

### Density

Tells us:

> How much mass is present per unit volume?

Unit:

```text
kg/m³
```

Therefore:

```text
Mass ≠ Density
```

---

# 1.3.11 Density vs Specific Weight

### Density

```math
\rho = \frac{m}{V}
```

Unit:

```text
kg/m³
```

It is based on **mass**.

### Specific weight

```math
\gamma = \frac{W}{V}
```

Unit:

```text
N/m³
```

It is based on **weight**.

Since:

```math
W = mg
```

we get:

```math
\gamma = \rho g
```

We will study specific weight separately in **Topic 1.4**.

---

# 1.3.12 Density and Pressure

Density is related to pressure differently for **liquids** and **gases**.

### Liquids

Liquids are generally treated as nearly incompressible.

Therefore, for ordinary pressure changes:

```text
Density ≈ constant
```

### Gases

Gases are compressible.

Therefore:

```text
Pressure ↑ → Density ↑
```

and generally:

```text
Pressure ↓ → Density ↓
```

for approximately constant temperature.

### AMVI ⭐

> Pressure has a much more noticeable effect on the density of gases than on ordinary liquids.

---

# 1.3.13 Effect of Temperature on Density

This is an important concept.

The basic relationship is:

```math
\rho = \frac{m}{V}
```

For a given amount of fluid, mass is generally constant.

Therefore, if temperature changes the volume, density also changes.

---

## A. Effect of Temperature on Liquids

For most liquids:

```text
Temperature ↑
      ↓
Volume ↑
      ↓
Density ↓
```

Similarly:

```text
Temperature ↓
      ↓
Volume ↓
      ↓
Density ↑
```

### Example

Take a fixed mass of oil.

When heated:

* mass remains essentially constant
* volume increases
* density decreases

because:

```math
\rho = \frac{m}{V}
```

If `V` increases while `m` remains constant, `ρ` decreases.

### AMVI ⭐

> **For most liquids, density decreases when temperature increases.**

---

# 1.3.14 Special Case — Water

Water behaves unusually around **0°C to 4°C**.

When water is heated from:

```text
0°C → 4°C
```

its density **increases**.

Water reaches its **maximum density at approximately 4°C**.

Approximately:

```text
ρwater at 4°C ≈ 1000 kg/m³
```

Above 4°C:

```text
Temperature ↑ → Density ↓
```

So:

```text
0°C → 4°C
Density ↑
```

and:

```text
4°C → higher temperature
Density ↓
```

### Very important AMVI trap ⭐⭐⭐

> **Water has maximum density at approximately 4°C.**

This is called the **anomalous expansion of water**.

---

# 1.3.15 Effect of Temperature on Gases

Gases are strongly affected by temperature.

For a fixed mass of gas at approximately constant pressure:

```text
Temperature ↑
      ↓
Volume ↑
      ↓
Density ↓
```

Therefore:

> **At constant pressure, increasing the temperature of a gas decreases its density.**

This is one reason hot air rises.

Hot air has lower density than surrounding cooler air, so buoyancy can cause it to rise.

---

# 1.3.16 Density and Temperature — Summary

| Fluid                      | Temperature increases | Density |
| -------------------------- | --------------------- | ------- |
| Most liquids               | ↑                     | ↓       |
| Gases at constant pressure | ↑                     | ↓       |
| Water from 0°C to 4°C      | ↑                     | ↑       |
| Water above 4°C            | ↑                     | ↓       |

### Remember:

> **Most fluids: heating → density decreases.**
> **Water between 0°C and 4°C is the important exception.**

---

# 1.3.17 Effect of Pressure on Density

## Liquids

Liquids are nearly incompressible.

Therefore, increasing pressure generally produces only a **very small increase in density**.

For ordinary engineering problems:

```text
ρ ≈ constant
```

is often assumed.

### But technically:

```text
Pressure ↑ → Liquid density slightly ↑
```

because liquids are not perfectly incompressible.

---

## Gases

For gases, pressure has a significant effect.

At approximately constant temperature:

```text
Pressure ↑ → Density ↑
```

and:

```text
Pressure ↓ → Density ↓
```

This follows from the ideal-gas relation:

```math
PV = mRT
```

Since:

```math
\rho = \frac{m}{V}
```

we can obtain:

```math
P = \rho RT
```

or:

```math
\rho = \frac{P}{RT}
```

Therefore, at constant temperature:

```text
ρ ∝ P
```

### AMVI ⭐⭐⭐

> For a gas at constant temperature, **density is directly proportional to pressure**.

---

# 1.3.18 Effect of Gravity on Density

Density itself does **not directly depend on gravitational acceleration**.

Formula:

```math
\rho = \frac{m}{V}
```

There is no `g` in this formula.

Therefore:

> Changing gravitational acceleration does not directly change density.

However, gravity can influence pressure distribution in a fluid.

For example:

```math
P = \rho gh
```

Here `g` affects pressure, not the basic definition of density.

---

# 1.3.19 Other Factors Affecting Density

Density can be influenced by:

### 1. Temperature

Generally:

```text
Temperature ↑ → Density ↓
```

for most liquids and gases under common conditions.

---

### 2. Pressure

Especially important for gases:

```text
Pressure ↑ → Density ↑
```

at constant temperature.

---

### 3. Composition

Different fluids have different densities.

For example:

```text
Water ≠ Oil ≠ Mercury
```

because their molecular composition is different.

---

### 4. Concentration

For mixtures and solutions, changing concentration can change density.

Example:

Adding dissolved material to water can change its density.

---

### 5. Phase

The same substance can have different densities in different phases.

For example:

```text
Water
Liquid → high density
Steam → much lower density
```

---

# 1.3.20 Density and Phase Change

Density changes significantly during phase changes.

For example, when water changes from:

```text
Liquid → Steam
```

its volume increases enormously.

Since:

```math
\rho = \frac{m}{V}
```

and mass remains the same, the huge increase in volume results in a large decrease in density.

### Therefore:

> Steam has a much lower density than liquid water.

---

# 1.3.21 Important Numerical Example

### Question

A fluid has a mass of 20 kg and occupies 0.02 m³. Find its density.

Given:

```text
m = 20 kg
V = 0.02 m³
```

Formula:

```math
\rho = \frac{m}{V}
```

Therefore:

```math
\rho = \frac{20}{0.02}
```

```text
ρ = 1000 kg/m³
```

### Answer:

**1000 kg/m³**

---

# 1.3.22 Numerical Example — Mass

Density of a fluid is 800 kg/m³ and its volume is 5 m³. Find its mass.

```math
m = \rho V
```

```math
m = 800 \times 5
```

```text
m = 4000 kg
```

### Answer:

**4000 kg**

---

# 1.3.23 Numerical Example — Volume

A fluid has mass 500 kg and density 1000 kg/m³. Find its volume.

```math
V = \frac{m}{\rho}
```

```math
V = \frac{500}{1000}
```

```text
V = 0.5 m³
```

### Answer:

**0.5 m³**

---

# 1.3.24 AMVI Important Points ⭐⭐⭐

1. Density = **mass per unit volume**.

2. Symbol:

```text
ρ
```

3. Formula:

```math
\rho = \frac{m}{V}
```

4. SI unit:

```text
kg/m³
```

5. Dimensional formula:

```text
ML⁻³
```

6. Density is a **scalar quantity**.

7. Approximate density of water:

```text
1000 kg/m³
```

8. Approximate density of water at maximum density condition:

```text
≈ 1000 kg/m³ at 4°C
```

9. Water has **maximum density at approximately 4°C**.

10. Most liquids expand when heated, so their density decreases.

11. Gases are highly compressible.

12. For a gas at constant temperature:

```text
ρ ∝ P
```

13. Gravity does not directly appear in the density equation.

14. Specific weight is related to density by:

```math
\gamma = \rho g
```

15. Density and specific gravity are related by:

```math
SG = \frac{\rho_{fluid}}{\rho_{water}}
```

---

# 1.3.25 Common AMVI Traps 🚨

### Trap 1

**Density = weight/volume**

❌ Wrong.

That is **specific weight**.

Correct:

```math
\rho = \frac{m}{V}
```

---

### Trap 2

**Density increases when most liquids are heated.**

❌ Wrong.

Generally:

```text
Heating → Expansion → Volume ↑ → Density ↓
```

---

### Trap 3

**Density of water is maximum at 0°C.**

❌ Wrong.

Correct:

> Maximum density of water occurs at approximately **4°C**.

---

### Trap 4

**Density depends directly on gravity.**

❌ Wrong.

Density:

```math
\rho = \frac{m}{V}
```

Specific weight:

```math
\gamma = \rho g
```

---

### Trap 5

**All liquids are perfectly incompressible.**

❌ Wrong.

Liquids are **approximately treated as incompressible** in many engineering applications.

---

# 1.3.26 AMVI MCQs

### MCQ 1

Density of a fluid is:

A. Weight per unit volume
B. Mass per unit volume
C. Volume per unit mass
D. Mass per unit area

**Answer: B**

---

### MCQ 2

The SI unit of density is:

A. N/m³
B. N/m²
C. kg/m³
D. kg/m²

**Answer: C**

---

### MCQ 3

Dimensional formula of density is:

A. `ML⁻¹T⁻²`
B. `ML⁻²`
C. `ML⁻³`
D. `M⁰L⁻³`

**Answer: C**

---

### MCQ 4

Maximum density of water occurs at approximately:

A. 0°C
B. 4°C
C. 25°C
D. 100°C

**Answer: B**

---

### MCQ 5

For most liquids, when temperature increases, density:

A. Increases
B. Decreases
C. Remains exactly constant
D. Becomes zero

**Answer: B**

---

### MCQ 6

For an ideal gas at constant temperature, if pressure increases, density:

A. Decreases
B. Increases
C. Remains constant
D. Becomes zero

**Answer: B**

---

### MCQ 7

Specific weight is related to density by:

A. `γ = ρ/g`
B. `γ = ρg`
C. `γ = ρ + g`
D. `γ = ρ - g`

**Answer: B**

---

### MCQ 8

A fluid has mass 50 kg and volume 0.05 m³. Its density is:

A. 100 kg/m³
B. 500 kg/m³
C. 1000 kg/m³
D. 2000 kg/m³

```math
\rho = \frac{50}{0.05} = 1000\;kg/m^3
```

**Answer: C**

---

# 1.3.27 Final Revision Table

| Property                          | Density              |
| --------------------------------- | -------------------- |
| Definition                        | Mass per unit volume |
| Symbol                            | `ρ`                  |
| Formula                           | `ρ = m/V`            |
| SI unit                           | kg/m³                |
| CGS unit                          | g/cm³                |
| Dimension                         | `ML⁻³`               |
| Type                              | Scalar               |
| Water density                     | ≈ 1000 kg/m³         |
| Maximum density of water          | ≈ 4°C                |
| Most liquids when heated          | Density decreases    |
| Gas: pressure ↑ at constant T     | Density increases    |
| Gravity directly affects density? | No                   |
| Relation with specific weight     | `γ = ρg`             |

---

## 🧠 One-Minute AMVI Revision

```text
DENSITY
   ↓
Mass / Volume
   ↓
ρ = m/V
   ↓
SI = kg/m³
   ↓
Dimension = ML⁻³
   ↓
Scalar quantity
   ↓
Water ≈ 1000 kg/m³
   ↓
Water maximum density ≈ 4°C
   ↓
Most liquids:
Temperature ↑ → Density ↓
   ↓
Gas:
Pressure ↑ → Density ↑
(at constant temperature)
   ↓
Specific weight:
γ = ρg
```

**Topic 1.3 Density is now complete: concept → formula → units → dimensions → examples → temperature → pressure → other factors → AMVI traps → MCQs.**

Next we should take **1.4 Specific Weight** in exactly the same combined format.
