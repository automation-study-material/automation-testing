# Specific Weight / Weight density — AMVI Notes

## 1. Definition

**Specific weight** is the **weight of fluid per unit volume**.

It is represented by:

```math
\gamma = \frac{W}{V}
```

Since:

```math
W = mg
```

and:

```math
\rho = \frac{m}{V}
```

we get:

```math
\gamma = \rho g
```

### Therefore, the most important formula is:

```math
\boxed{\gamma = \rho g}
```

Where:

* `γ` = specific weight
* `ρ` = density
* `g` = acceleration due to gravity

---

# 2. SI Unit

Weight = Newton (N)

Volume = `m³`

Therefore:

```math
\gamma = \frac{N}{m^3}
```

### SI unit:

**N/m³**

It is also commonly written as:

**kN/m³**

For water:

```text
ρ ≈ 1000 kg/m³
g ≈ 9.81 m/s²
```

Therefore:

```math
\gamma = 1000 \times 9.81
```

```math
\gamma \approx 9810\ N/m^3
```

or:

```text
γ ≈ 9.81 kN/m³
```

### AMVI value to remember

> **Specific weight of water ≈ 9.81 kN/m³**

Sometimes exam problems use `g = 9.8 m/s²`, giving:

```text
γwater ≈ 9.8 kN/m³
```

---

# 3. Dimension of Specific Weight

We know:

```math
\gamma = \rho g
```

Density:

```math
[\rho] = ML^{-3}
```

Acceleration due to gravity:

```math
[g] = LT^{-2}
```

Therefore:

```math
[\gamma] = ML^{-3} \times LT^{-2}
```

```math
\boxed{[\gamma] = ML^{-2}T^{-2}}
```

### AMVI MCQ

**Dimension of specific weight is:**

`ML⁻²T⁻²` ✅

Do not confuse it with density:

```text
Density → ML⁻³
Specific weight → ML⁻²T⁻²
```

---

# 4. Specific Weight vs Density

This distinction is extremely important for MCQs.

| Property        | Density       | Specific Weight |
| --------------- | ------------- | --------------- |
| Symbol          | `ρ`           | `γ`             |
| Meaning         | Mass / volume | Weight / volume |
| Formula         | `ρ = m/V`     | `γ = W/V`       |
| Relationship    | —             | `γ = ρg`        |
| SI unit         | kg/m³         | N/m³            |
| Dimension       | `ML⁻³`        | `ML⁻²T⁻²`       |
| Depends on `g`? | No            | **Yes**         |

### Memory trick

> **Density → Mass**
> **Specific weight → Weight**

Since:

```text
Weight = Mass × g
```

therefore:

```math
\gamma = \rho g
```

---

# 5. How Does Specific Weight Change?

This is particularly important for AMVI MCQs.

Start with:

```math
\gamma = \rho g
```

For a given location:

```text
g ≈ constant
```

Therefore:

```math
\gamma \propto \rho
```

So anything that changes density will also change specific weight.

---

# 6. Effect of Temperature on Specific Weight

## For most liquids

When temperature increases:

```text
Temperature ↑
     ↓
Volume ↑
     ↓
Density ↓
     ↓
Specific weight ↓
```

Because:

```math
\gamma = \rho g
```

and `g` is approximately constant.

Therefore:

> **For most liquids, increase in temperature → decrease in specific weight.**

---

## Example

Suppose water has:

```text
ρ₁ = 1000 kg/m³
```

At a higher temperature, suppose density becomes:

```text
ρ₂ = 998 kg/m³
```

Then:

```math
\gamma_1 = 1000 \times 9.81
```

```text
γ₁ = 9810 N/m³
```

At higher temperature:

```math
\gamma_2 = 998 \times 9.81
```

```text
γ₂ ≈ 9790.38 N/m³
```

Therefore:

```text
Temperature ↑ → Specific weight ↓
```

for this case.

---

# 7. Important Exception: Water

Water has an unusual density-temperature relationship between **0°C and 4°C**.

Water has approximately maximum density at:

> **4°C**

Therefore:

```text
0°C → density increases → specific weight increases
4°C → maximum density → maximum specific weight
Above 4°C → density decreases → specific weight decreases
```

Conceptually:

```text
Specific Weight
      ↑
      │          ● Maximum
      │         / \
      │        /   \
      │_______/     \________
              4°C
                    → Temperature
```

### AMVI Trap

If the question says:

> "Temperature of water is increased from 2°C to 4°C"

Then:

```text
Density ↑
Specific weight ↑
```

But if:

> "Temperature of water is increased from 4°C to 10°C"

Then:

```text
Density ↓
Specific weight ↓
```

### Remember

> **Water has maximum density and therefore maximum specific weight at approximately 4°C.**

---

# 8. Effect of Pressure on Specific Weight

Again:

```math
\gamma = \rho g
```

So the effect of pressure depends on how pressure changes density.

---

## Liquids

Liquids are **slightly compressible**.

When pressure increases:

```text
Pressure ↑
    ↓
Liquid compressed slightly
    ↓
Density ↑ slightly
    ↓
Specific weight ↑ slightly
```

Therefore:

> **For a liquid, increasing pressure generally increases specific weight slightly.**

However, under ordinary engineering conditions, liquids are often treated as incompressible:

```math
\rho \approx constant
```

Hence:

```math
\gamma \approx constant
```

### AMVI wording

If the question says:

> "Effect of pressure on specific weight of an incompressible liquid?"

Answer:

**Approximately no change.**

If it asks about a **real liquid**, the more precise answer is:

**Specific weight increases slightly with pressure.**

---

# 9. Effect of Pressure on Gases

For gases, compressibility is much more significant.

At constant temperature:

```math
PV = mRT
```

Therefore:

```math
\rho = \frac{P}{RT}
```

At constant temperature:

```math
\rho \propto P
```

Since:

```math
\gamma = \rho g
```

and `g` is constant:

```math
\gamma \propto P
```

Therefore:

> **For a gas at constant temperature, increase in pressure → increase in density → increase in specific weight.**

### Very important MCQ

**For a gas at constant temperature, if pressure is doubled:**

```text
Density → approximately doubles
Specific weight → approximately doubles
```

---

# 10. Effect of Temperature on Gases

For an ideal gas:

```math
\rho = \frac{P}{RT}
```

At constant pressure:

```math
\rho \propto \frac{1}{T}
```

Therefore:

```text
Temperature ↑
     ↓
Density ↓
     ↓
Specific weight ↓
```

So:

> **For a gas at constant pressure, increase in temperature → decrease in specific weight.**

---

# 11. Summary of Temperature & Pressure Effects

| Fluid/Condition           | Temperature ↑                    | Pressure ↑      |
| ------------------------- | -------------------------------- | --------------- |
| Most liquids              | `ρ ↓` → `γ ↓`                    | `γ ↑ slightly`  |
| Incompressible liquid     | `γ` generally ↓ with temperature | `γ ≈ constant`  |
| Gas, constant pressure    | `γ ↓`                            | —               |
| Gas, constant temperature | —                                | `γ ↑`           |
| Water 0–4°C               | `γ ↑`                            | slight increase |
| Water above 4°C           | `γ ↓`                            | slight increase |

### 🔥 AMVI memory

```text
Most liquids:
T ↑ → γ ↓

Water:
0 → 4°C : γ ↑
Above 4°C : γ ↓

Gas:
T ↑ at constant P → γ ↓
P ↑ at constant T → γ ↑
```

---

# 12. Effect of Gravity on Specific Weight

From:

```math
\gamma = \rho g
```

If density remains constant:

```math
\gamma \propto g
```

Therefore:

> **Specific weight depends on gravitational acceleration.**

This is an important difference between density and specific weight.

### Density

```math
\rho = \frac{m}{V}
```

does **not directly depend on `g`**.

### Specific weight

```math
\gamma = \rho g
```

**does depend on `g`.**

---

# 13. Effect of Altitude

As altitude increases, gravitational acceleration `g` decreases slightly.

Therefore, if density is assumed unchanged:

```text
Altitude ↑
   ↓
g ↓
   ↓
γ ↓
```

So:

> **Specific weight decreases slightly with altitude due to decrease in `g`, if density is held constant.**

For gases, altitude also changes pressure and density, so the actual change in gas specific weight can be more significant.

### AMVI trap

Do not simply say:

> "Specific weight is independent of location."

❌ Wrong.

Specific weight contains `g`.

```math
\gamma = \rho g
```

---

# 14. Specific Weight and Specific Gravity

You have already studied specific gravity.

Specific gravity:

```math
SG = \frac{\rho_{fluid}}{\rho_{water}}
```

Since:

```math
\gamma = \rho g
```

we can also write:

```math
SG = \frac{\gamma_{fluid}}{\gamma_{water}}
```

because `g` cancels when both are at the same location.

Therefore:

> **Specific gravity can be calculated using either density or specific weight.**

---

## Example

A liquid has:

```text
SG = 0.8
```

Specific weight of water:

```text
γwater = 9.81 kN/m³
```

Then:

```math
SG = \frac{\gamma_{fluid}}{\gamma_{water}}
```

Therefore:

```math
\gamma_{fluid} = SG \times \gamma_{water}
```

```math
\gamma_{fluid} = 0.8 \times 9.81
```

```text
γfluid = 7.848 kN/m³
```

---

# 15. Specific Weight and Pressure Head

This connects directly with your previous topic.

Pressure head:

```math
h_p = \frac{P}{\rho g}
```

Since:

```math
\gamma = \rho g
```

we can write:

```math
\boxed{h_p = \frac{P}{\gamma}}
```

This is a very useful AMVI formula.

### Therefore:

```text
Pressure head = Pressure / Specific weight
```

For water:

```text
γ ≈ 9.81 kN/m³
```

If:

```text
P = 98.1 kPa
```

then:

```math
h_p = \frac{98.1}{9.81}
```

```text
h_p = 10 m
```

---

# 16. Important Numerical Relationships

### If density is known

```math
\gamma = \rho g
```

### If specific weight is known

```math
\rho = \frac{\gamma}{g}
```

### If pressure and pressure head are known

```math
\gamma = \frac{P}{h_p}
```

### If pressure head is required

```math
h_p = \frac{P}{\gamma}
```

---

# 17. AMVI MCQ Practice

### MCQ 1

Specific weight is defined as:

A. Mass per unit volume
B. Weight per unit volume
C. Force per unit area
D. Volume per unit mass

**Answer: B — Weight per unit volume**

---

### MCQ 2

The relation between density and specific weight is:

A. `γ = ρ/g`
B. `γ = ρg`
C. `γ = g/ρ`
D. `γ = ρ + g`

**Answer: B**

```math
\gamma = \rho g
```

---

### MCQ 3

SI unit of specific weight is:

A. kg/m³
B. N/m²
C. N/m³
D. m²/s

**Answer: C — N/m³**

---

### MCQ 4

Dimension of specific weight is:

A. `ML⁻³`
B. `ML⁻¹T⁻²`
C. `ML⁻²T⁻²`
D. `L²T⁻¹`

**Answer: C**

```text
ML⁻²T⁻²
```

---

### MCQ 5

For most liquids, when temperature increases, specific weight:

A. Increases
B. Decreases
C. Remains exactly constant
D. Becomes zero

**Answer: B — Decreases**

---

### MCQ 6

Maximum density of water occurs approximately at:

A. 0°C
B. 2°C
C. 4°C
D. 100°C

**Answer: C — 4°C**

Therefore maximum specific weight of water also occurs approximately at:

**4°C**

---

### MCQ 7

For an ideal gas at constant temperature, pressure is doubled. Specific weight:

A. Halves
B. Remains same
C. Doubles
D. Becomes zero

**Answer: C — Doubles**

Because:

```math
\rho \propto P
```

and:

```math
\gamma = \rho g
```

---

### MCQ 8

For an ideal gas at constant pressure, temperature increases. Specific weight:

A. Increases
B. Decreases
C. Remains constant
D. Becomes infinite

**Answer: B — Decreases**

---

### MCQ 9

Which property depends directly on gravitational acceleration?

A. Density
B. Specific weight
C. Specific volume
D. Specific gravity

**Answer: B — Specific weight**

Because:

```math
\gamma = \rho g
```

---

### MCQ 10

Pressure head can be written in terms of specific weight as:

A. `Pγ`
B. `γ/P`
C. `P/γ`
D. `P+γ`

**Answer: C**

```math
h_p = \frac{P}{\gamma}
```

---

# 🔥 AMVI Exam Traps — Must Remember

1. **Density ≠ Specific weight**

   * Density → kg/m³
   * Specific weight → N/m³

2. **Specific weight = density × gravity**

   ```math
   \gamma = \rho g
   ```

3. **Specific weight depends on `g`; density does not directly.**

4. **Most liquids:**

   ```text
   Temperature ↑ → Specific weight ↓
   ```

5. **Water:**

   ```text
   Maximum density → 4°C
   Maximum specific weight → 4°C
   ```

6. **Liquids are slightly compressible**, so pressure increase generally increases specific weight slightly.

7. **Incompressible liquid:**

   ```text
   Pressure change → γ approximately constant
   ```

8. **Gas at constant temperature:**

   ```text
   P ↑ → γ ↑
   ```

9. **Gas at constant pressure:**

   ```text
   T ↑ → γ ↓
   ```

10. **Pressure head:**

```math
h_p = \frac{P}{\gamma}
```

11. **Specific gravity can be written as:**

```math
SG = \frac{\gamma_{fluid}}{\gamma_{water}}
```

---

# 🧠 One-Minute Revision

```text
SPECIFIC WEIGHT
      │
      ├── Weight / Volume
      │
      ├── γ = ρg
      │
      ├── Unit = N/m³
      │
      ├── Dimension = ML⁻²T⁻²
      │
      ├── Most liquids:
      │      T ↑ → γ ↓
      │
      ├── Water:
      │      γ maximum at ≈ 4°C
      │
      ├── Liquid:
      │      P ↑ → γ ↑ slightly
      │
      ├── Incompressible liquid:
      │      P ↑ → γ ≈ constant
      │
      ├── Gas:
      │      P ↑ at constant T → γ ↑
      │      T ↑ at constant P → γ ↓
      │
      └── Pressure head:
             hp = P/γ
```

### ⭐ Three formulas to lock in

```math
\boxed{\gamma = \rho g}
```

```math
\boxed{h_p = \frac{P}{\gamma}}
```

```math
\boxed{SG = \frac{\gamma_{fluid}}{\gamma_{water}}}
```

These are the core relationships you should use for **Specific Weight AMVI MCQs and numericals**.
