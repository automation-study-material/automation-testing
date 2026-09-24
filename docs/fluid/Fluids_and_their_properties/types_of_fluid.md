
# 1.2 Types of Fluids

## 📌 Syllabus Mapping

**Syllabus Keyword:** Fluids and Their Properties

**Topic:** 1.2 Types of Fluid

---

# 1.2.1 Introduction

A **fluid** can be classified in different ways depending on the property or behavior being considered.

For AMVI preparation, the most important classifications are:

1. **Ideal Fluid**
2. **Real Fluid**
3. **Newtonian Fluid**
4. **Non-Newtonian Fluid**

These classifications are based on **different characteristics**.

---

# 1.2.2 Basic Classification of Fluids

```text
                              FLUIDS
                                 │
             ┌───────────────────┴───────────────────┐
             │                                       │
       Based on Idealization                  Based on Viscous
             │                                  Behaviour
       ┌─────┴─────┐                       ┌─────┴─────┐
       │           │                       │           │
     Ideal        Real                 Newtonian   Non-Newtonian
     Fluid        Fluid                   Fluid        Fluid
```

### Important

**Ideal/Real** and **Newtonian/Non-Newtonian** are two different classifications.

For example:

> Water is a **real fluid** and approximately a **Newtonian fluid**.

---

# 1.2.3 Ideal Fluid

## Definition

An **ideal fluid** is a hypothetical fluid that is assumed to be:

* **Incompressible**
* **Non-viscous**

Therefore:

$$
\boxed{\rho = \text{constant}}
$$

and

$$
\boxed{\mu = 0}
$$

Where:

* $\rho$ = density
* $\mu$ = dynamic viscosity

### Simple Definition

> **Ideal fluid = Incompressible + Non-viscous**

---

## 1.2.4 Characteristics of an Ideal Fluid

An ideal fluid is assumed to have:

1. **Zero viscosity**
2. **Constant density**
3. No viscous resistance
4. No shear stress due to viscosity
5. No energy loss due to viscous friction
6. No frictional loss during flow

### ⭐ AMVI Point

The ideal fluid is a **theoretical/hypothetical concept**.

A perfectly ideal fluid does not exist in nature.

---

# 1.2.5 What Does Non-Viscous Mean?

A non-viscous fluid has:

$$
\boxed{\mu = 0}
$$

Therefore, there is no viscous resistance between adjacent fluid layers.

Compare:

```text
Viscous fluid

Layer 1  → → → → →
Layer 2    → → → →
Layer 3      → → →
       ↓
Resistance between layers
```

For an ideal non-viscous fluid:

```text
Ideal fluid

Layer 1  → → → → →
Layer 2  → → → → →
Layer 3  → → → → →

No viscous resistance
```

---

# 1.2.6 What Does Incompressible Mean?

An incompressible fluid is a fluid whose **density remains essentially constant**.

$$
\boxed{\rho = \text{constant}}
$$

For most engineering applications:

* Water is treated as approximately incompressible.
* Oil is treated as approximately incompressible.

Gases, however, can undergo significant density changes, especially when pressure changes significantly.

### ⭐ Important

Do not confuse:

> **Incompressible** → Density remains constant

with:

> **Non-viscous** → Viscosity is zero

They are two different properties.

---

# 1.2.7 Does an Ideal Fluid Exist in Reality?

A perfectly ideal fluid does **not** exist in nature.

It is a **hypothetical model** used to simplify fluid mechanics problems.

For example, when deriving the basic form of Bernoulli's equation, the fluid is often assumed to be:

* Steady
* Incompressible
* Inviscid

where:

> **Inviscid = Zero viscosity**

---

# 1.2.8 Real Fluid

## Definition

A **real fluid** is an actual fluid that possesses viscosity.

Therefore:

$$
\boxed{\mu > 0}
$$

Real fluids also have finite physical properties such as density and viscosity.

### Simple Definition

> **Real fluid = Actual fluid having viscosity**

---

# 1.2.9 Characteristics of Real Fluids

A real fluid:

1. Has viscosity.
2. Offers resistance to relative motion between fluid layers.
3. Can develop shear stress during flow.
4. Experiences viscous/frictional effects.
5. Can lose mechanical energy due to viscous effects.

---

# 1.2.10 Examples of Real Fluids

Almost all practical fluids are real fluids.

### Liquids

* Water
* Engine oil
* Petrol
* Diesel
* Kerosene
* Hydraulic oil
* Brake fluid
* Gear oil
* Transmission fluid
* Coolant
* Milk
* Honey

### Gases

* Air
* Oxygen
* Nitrogen
* Carbon dioxide
* Steam

---

# 1.2.11 Ideal Fluid vs Real Fluid

| Property | Ideal Fluid | Real Fluid |
|---|---|---|
| Nature | Hypothetical | Actual |
| Compressibility | Very low | May be significant depending on conditions |
| Viscosity | Zero | Greater than zero |
| Dynamic viscosity | `μ = 0` | `μ > 0` |
| Density | Assumed constant | May vary depending on conditions |
| Viscous resistance | Absent | Present |
| Viscous energy loss | Absent | Present |
| Existence | Does not exist perfectly in nature | Exists in nature |
| Example | Theoretical model | Water, oil, air |

# 1.2.12 Newtonian Fluid

## 🔹 What is Newton's Law of Viscosity?

Newton's law of viscosity explains the relationship between:

- **Shear stress** acting on a fluid
- **Velocity gradient** within the fluid

When one layer of fluid moves relative to another layer, there is a difference in velocity between the layers.

Because of **viscosity**, the faster-moving layer tends to drag the slower-moving layer. This produces resistance to relative motion between fluid layers.

Newton's law states:

> **The shear stress required to maintain fluid motion is directly proportional to the velocity gradient.**

In simple words:

> **More difference in velocity between adjacent fluid layers means more shear stress is required.**

Mathematically:

```math
\tau\propto\frac{du}{dy}
```

Therefore:

```math
\tau=\mu\frac{du}{dy}
```

> **μ (Greek letter mu) is called dynamic viscosity or coefficient of dynamic viscosity.**

This equation is called **Newton's law of viscosity**.

---

# 1.2.10 Understanding Newton's Law of Viscosity

Consider fluid flowing between two parallel surfaces.

```
          Upper surface
          ───────────────→
                 u = U

          Fluid layers
          → → → → → → →
          → → → → →
          → → →
          →

          Lower surface
          ───────────────
                 u = 0

```


The lower surface is stationary.

Therefore, the fluid layer touching the lower surface has approximately:

```math
u=0
```

## 1. `u` — Fluid velocity

`u` represents the **velocity of the fluid layer**.

The fluid is moving horizontally, so `u` is the velocity in the horizontal direction.

For example:

```text
Upper layer → → → → →    u = high
Middle layer → → →       u = medium
Lower layer →             u = low
```

Its unit is:

```text
m/s
```

---

## 2. `U` — Velocity of the upper surface

In the diagram:

```text
Upper surface
───────────────→
       u = U
```

`U` represents the **velocity of the upper moving surface**.

For example, if the upper plate is moving at:

```text
U = 5 m/s
```

then the fluid layer immediately touching that surface has approximately:

```math
u=U=5\ m/s
```

This happens because of the **no-slip condition**.

---

## 3. `y` — Distance perpendicular to the surfaces

`y` represents the distance measured **perpendicular to the fluid layers**.

```text
             Upper plate
             ─────────────
                  ↑
                  │ y
                  │
             Fluid│
                  │
                  ↓
             ─────────────
             Lower plate
```

So `y` tells us **how far we are from the lower surface**.

Its unit is:

```text
m
```

---

## 4. `du` — Small change in velocity

`du` means a **small change in fluid velocity**.

For example, suppose:

```text
At one layer:     u = 2.0 m/s
At another layer: u = 2.1 m/s
```

Then:

```math
du=2.1-2.0=0.1\ m/s
```

---

## 5. `dy` — Small change in distance

`dy` means a **small change in distance between two nearby fluid layers**.

For example:

```text
Layer 1
────────────
     ↑
     │ dy
     ↓
────────────
Layer 2
```

---

## 6. `du/dy` — Velocity gradient ⭐

This is the most important parameter in this diagram.

```math
\frac{du}{dy}
```

It means:

> **Rate of change of fluid velocity with respect to distance perpendicular to the fluid layers.**

In simple words:

> **How quickly velocity changes as we move from one fluid layer to another.**

For example:

```text
        Upper surface
        u = 10 m/s
        ─────────────
             ↑
             │
             │ velocity changes
             │
             ↓
        ─────────────
        Lower surface
        u = 0
```

Velocity changes from:

```text
0 m/s → 10 m/s
```

over the distance between the two surfaces.

Therefore, there is a velocity gradient.

---

# 7. `τ` — Shear stress

Although `τ` isn't explicitly shown in your diagram, it is directly related to this situation.

When adjacent fluid layers move at different velocities, **viscosity produces resistance between the layers**.

This resistance is represented by **shear stress**:

```math
\tau
```

Unit:

```text
Pa = N/m²
```

Newton's law connects shear stress with velocity gradient:

```math
\tau=\mu\frac{du}{dy}
```

---

# 8. `μ` — Dynamic viscosity

`μ` represents the **dynamic viscosity** of the fluid.


### Easy derivation

```math
\tau=\mu\frac{du}{dy}
```

Divide both sides by `du/dy`:

```math
\frac{\tau}{du/dy}=\mu
```

Therefore:

```math
\boxed{\mu=\frac{\tau}{du/dy}}
```

It tells us how strongly the fluid resists relative motion between its layers.

```text
Low μ
 ↓
Less resistance to flow

High μ
 ↓
More resistance to flow
```

Unit:

```text
SI unit of dynamic viscosity = Pa·s (or N·s/m²)

CGS unit of dynamic viscosity = Poise (P)

```
| Quantity                |   Symbol |  SI Unit |
| ----------------------- | -------: | -------: |
| Pressure / Shear stress | `P`, `τ` |   **Pa** |
| Dynamic viscosity       |      `μ` | **Pa·s** |
| Kinematic viscosity     |      `ν` | **m²/s** |


---



---

# 1.2.19 Kinematic Viscosity vs Dynamic Viscosity

## 1.2.19.1 First: What is Viscosity?

Imagine two layers of fluid moving at different speeds:

```text
        Fast layer
    → → → → → → → → →
    ───────────────────

        Slow layer
      → → → → →
    ───────────────────
```

Because of internal friction, the faster layer tries to drag the slower layer along with it.

This **resistance to relative motion between fluid layers** is called **viscosity**.

There are two important ways of expressing viscosity:

1. **Dynamic viscosity (`μ`)**
2. **Kinematic viscosity (`ν`)**

---

## 1.2.19.2 Dynamic Viscosity (`μ`)

Dynamic viscosity tells us:

> **How much resistance a fluid offers to the relative motion of its layers.**

It directly relates **shear stress** to **velocity gradient**.

Newton's law of viscosity:

```math
\tau=\mu\frac{du}{dy}
```

Rearranging:

```math
\mu=\frac{\tau}{du/dy}
```

Where:

| Symbol | Meaning |
|---|---|
| `μ` | Dynamic viscosity |
| `τ` | Shear stress |
| `du/dy` | Velocity gradient |

### Unit

SI:

```text
Pa·s
```

Also:

```text
N·s/m²
```

CGS:

```text
Poise (P)
```

Important conversion:

```text
1 P = 0.1 Pa·s
1 Pa·s = 10 P
```

---

## 1.2.19.3 Why is it Called "Dynamic"?

It describes the **actual viscous resistance when fluid layers are moving relative to each other**.

For example:

```text
Honey
```

has high dynamic viscosity.

```text
Water
```

has much lower dynamic viscosity.

So, under comparable conditions:

```text
Honey → high μ → more resistance

Water → lower μ → less resistance
```

---

## 1.2.19.4 Kinematic Viscosity (`ν`)

Kinematic viscosity takes **density into account**.

It is defined as:

```math
\nu=\frac{\mu}{\rho}
```

Where:

- `ν` = Kinematic viscosity
- `μ` = Dynamic viscosity
- `ρ` = Density

Therefore:

> **Kinematic viscosity = Dynamic viscosity ÷ Density**

---

## 1.2.19.5 Why Do We Divide by Density?

Dynamic viscosity tells us about **viscous resistance**.

Fluid motion is also affected by **density**, which represents the mass present per unit volume.

Therefore, kinematic viscosity considers both:

```text
Viscous effect
      ↓
Dynamic viscosity (μ)

Density
      ↓
ρ
```

Hence:

```math
\nu=\frac{\mu}{\rho}
```

A useful way to remember it:

> **Dynamic viscosity → resistance**
>
> **Kinematic viscosity → dynamic viscosity relative to density**

---

## 1.2.19.6 Units of Kinematic Viscosity

We know:

```text
μ = Pa·s
ρ = kg/m³
```

Therefore:

```math
\nu=\frac{Pa\cdot s}{kg/m^3}
```

Since:

```text
Pa = kg/(m·s²)
```

we get:

```math
\nu
=
\frac{kg/(m\cdot s^2)\times s}{kg/m^3}
```

Therefore:

```math
\nu=m^2/s
```

### SI Unit ⭐

```text
m²/s
```

### CGS Unit

```text
Stokes (St)
```

Important conversion:

```text
1 St = 10⁻⁴ m²/s
1 m²/s = 10⁴ St
```

---

## 1.2.19.7 Most Important Formulas ⭐

```math
\boxed{\nu=\frac{\mu}{\rho}}
```

From this:

```math
\boxed{\mu=\rho\nu}
```

And:

```math
\boxed{\rho=\frac{\mu}{\nu}}
```

These forms are useful in numerical MCQs.

---

## 1.2.19.8 Simple Numerical Example

Suppose:

```text
Dynamic viscosity:

μ = 0.01 Pa·s
```

and:

```text
Density:

ρ = 1000 kg/m³
```

Find kinematic viscosity.

Using:

```math
\nu=\frac{\mu}{\rho}
```

Substitute:

```math
\nu=\frac{0.01}{1000}
```

Therefore:

```math
\nu=0.00001\ m^2/s
```

or:

```math
\boxed{\nu=1\times10^{-5}\ m^2/s}
```

---

## 1.2.19.9 Convert the Same Answer into Stokes

We know:

```text
1 St = 10⁻⁴ m²/s
```

Therefore:

```math
1\times10^{-5}\ m^2/s=0.1\ St
```

So:

```text
ν = 1 × 10⁻⁵ m²/s
  = 0.1 St
```

---

## 1.2.19.10 Easy Real-Life Understanding

Think about **honey and water**.

### Dynamic viscosity

If we ask:

> "How strongly does this fluid resist the motion of its layers?"

we are talking about:

```text
Dynamic viscosity (μ)
```

### Kinematic viscosity

If we ask:

> "How does this viscous behaviour compare with the fluid's density?"

we are talking about:

```text
Kinematic viscosity (ν)
```

because:

```math
\nu=\frac{\mu}{\rho}
```

---

## 1.2.19.11 Direct Comparison ⭐⭐⭐

| Property | Dynamic Viscosity | Kinematic Viscosity |
|---|---|---|
| Symbol | `μ` | `ν` |
| Meaning | Resistance to relative motion | Dynamic viscosity per unit density |
| Formula | `μ = τ/(du/dy)` | `ν = μ/ρ` |
| SI Unit | **Pa·s** | **m²/s** |
| Another SI Unit | N·s/m² | — |
| CGS Unit | **Poise (P)** | **Stokes (St)** |
| Depends on density? | Not in its definition | **Yes** |
| Used in Newton's law? | **Yes** | No |
| Dimension | `M L⁻¹ T⁻¹` | `L² T⁻¹` |

---

## 1.2.19.12 AMVI Memory Trick ⭐

```text
Dynamic viscosity
        ↓
      μ
        ↓
    Pa·s
        ↓
   Poise (P)
```

And:

```text
Kinematic viscosity
        ↓
      ν
        ↓
     μ / ρ
        ↓
     m²/s
        ↓
   Stokes (St)
```

### One-line memory trick

> **μ = Dynamic viscosity**
>
> **ν = Dynamic viscosity / Density**

---

## 1.2.19.13 Relationship Between Their Units

### Dynamic viscosity

```text
1 Pa·s = 10 P
1 P = 0.1 Pa·s
1 P = 100 cP
1 Pa·s = 1000 cP
1 cP = 0.001 Pa·s
1 cP = 0.01 P
```

### Kinematic viscosity

```text
1 St = 10⁻⁴ m²/s
1 m²/s = 10⁴ St
1 cSt = 10⁻⁶ m²/s
```

where `cSt` = centistokes.

---

## 1.2.19.14 Poise Conversion Chart ⭐

| Dynamic viscosity | Equivalent |
|---|---:|
| **1 P** | **0.1 Pa·s** |
| **1 P** | **100 cP** |
| **1 Pa·s** | **10 P** |
| **1 Pa·s** | **1000 cP** |
| **1 cP** | **0.001 Pa·s** |
| **1 cP** | **0.01 P** |

### AMVI Shortcut

```text
P → Pa·s : × 0.1
Pa·s → P : × 10

P → cP : × 100
cP → P : ÷ 100
```

### Example 1

Convert **5 P** into Pa·s:

```text
5 P × 0.1 = 0.5 Pa·s
```

### Example 2

Convert **0.25 Pa·s** into Poise:

```text
0.25 × 10 = 2.5 P
```

### Example 3

Convert **20 cP** into Pa·s:

```text
20 × 0.001 = 0.020 Pa·s
```

### Most Important MCQ Fact

> **1 P = 0.1 Pa·s = 100 cP**

---

# 1.2.20 Units Learned So Far

| Quantity | Symbol | SI Unit | CGS Unit | Important Conversion |
|---|---:|---|---|---|
| **Density** | `ρ` | kg/m³ | g/cm³ | `1 g/cm³ = 1000 kg/m³` |
| **Specific weight** | `γ` | N/m³ | dyn/cm³ | — |
| **Specific volume** | `v` | m³/kg | cm³/g | `1 m³/kg = 1000 cm³/g` |
| **Specific gravity** | `SG` | No unit | No unit | Dimensionless |
| **Dynamic viscosity** | `μ` | Pa·s | Poise (P) | `1 P = 0.1 Pa·s` |
| **Kinematic viscosity** | `ν` | m²/s | Stokes (St) | `1 St = 10⁻⁴ m²/s` |
| **Shear stress** | `τ` | Pa = N/m² | dyn/cm² | `1 Pa = 10 dyn/cm²` |
| **Pressure** | `P` | Pa = N/m² | dyn/cm² | `1 Pa = 10 dyn/cm²` |
| **Velocity** | `u` | m/s | cm/s | `1 m/s = 100 cm/s` |
| **Distance** | `y` | m | cm | `1 m = 100 cm` |
| **Velocity gradient** | `du/dy` | s⁻¹ | s⁻¹ | Same unit |

### ⭐ Most Important AMVI Conversions

```text
Density:
1 g/cm³ = 1000 kg/m³

Dynamic viscosity:
1 P = 0.1 Pa·s
1 Pa·s = 10 P
1 P = 100 cP
1 cP = 0.001 Pa·s

Kinematic viscosity:
1 St = 10⁻⁴ m²/s
1 m²/s = 10⁴ St
1 cSt = 10⁻⁶ m²/s

Velocity:
1 m/s = 100 cm/s

Pressure / Shear stress:
1 Pa = 10 dyn/cm²
```

---

# 1.2.21 AMVI MCQ Traps for Viscosity

### Trap 1

**SI unit of dynamic viscosity = Pa·s**

Not:

```text
Pa
```

`Pa` is the unit of pressure/stress.

---

### Trap 2

**SI unit of kinematic viscosity = m²/s**

Not:

```text
Pa·s
```

---

### Trap 3

**CGS unit of dynamic viscosity = Poise**

**CGS unit of kinematic viscosity = Stokes**

---

### Trap 4

Kinematic viscosity is:

```math
\boxed{\nu=\frac{\mu}{\rho}}
```

Not:

```math
\nu=\mu\rho
```

---

### Trap 5

Remember:

```text
μ → Dynamic viscosity → Pa·s → Poise

ν → Kinematic viscosity → m²/s → Stokes
```

---

# 1.2.22 Why is Shear Stress Proportional to Velocity Gradient?

Consider two situations.

## Case 1: Small Velocity Gradient

Suppose adjacent fluid layers have nearly the same velocity.

```
Layer 1 → → → → →
Layer 2 → → → →

```

**svg**

The velocity difference is small.

Therefore:

```math
\frac{du}{dy}=\text{small}
```

Hence:

```math
\tau=\text{small}
```

---

## Case 2: Large Velocity Gradient

Now suppose one layer is moving much faster than the adjacent layer.

```
Layer 1 → → → → → → → →
Layer 2 → → →

```

**svg**

The velocity changes rapidly over a small distance.

Therefore:

```math
\frac{du}{dy}=\text{large}
```

Hence greater shear stress is required.

```math
\tau=\text{large}
```

Therefore:

```math
\tau\propto\frac{du}{dy}
```

This direct proportionality is the fundamental characteristic of a **Newtonian fluid**.

---

# 1.2.23 Role of Dynamic Viscosity `μ`

From Newton's law:

```math
\tau=\mu\frac{du}{dy}
```

we get:

```math
\mu=\frac{\tau}{du/dy}
```

For a Newtonian fluid, at a given temperature:

> **Dynamic viscosity** **`μ`** **remains approximately constant even when the velocity gradient changes.**

This is a very important point.

For example, if the velocity gradient doubles:

```math
\frac{du}{dy}\rightarrow2\frac{du}{dy}
```

then:

```math
\tau\rightarrow2\tau
```

because:

```
μ = constant

```

**svg**

---

# 1.2.24 Example of Newton's Law of Viscosity

Suppose:

```math
\mu=0.5\ Pa\cdot s
```

and:

```math
\frac{du}{dy}=4\ s^{-1}
```

Using:

```math
\tau=\mu\frac{du}{dy}
```

we get:

```math
\tau=0.5\times4
```

Therefore:

```math
\tau=2\ Pa
```

### Answer:
**Shear stress =** **`2 Pa`**

---

---

# 1.2.25 Newtonian Fluid Graph


For a Newtonian fluid:

```text
Shear stress (τ)
       │
       │            /
       │          /
       │        /
       │      /
       │    /
       │  /
       │/
       └──────────────────────→ Velocity gradient (du/dy)
```

The graph is a:

> **Straight line passing through the origin**

The slope of the graph is:

$$
\boxed{\mu}
$$

Therefore:

> **Slope of $\tau$ vs $\frac{du}{dy}$ = Dynamic viscosity**

---

# 1.2.26 Examples of Newtonian Fluids

Common examples include:

* Water
* Air
* Petrol
* Diesel
* Kerosene
* Alcohol
* Glycerin
* Many simple mineral oils under specified conditions

### Automobile-related examples

#### Petrol

Approximately Newtonian under ordinary conditions.

#### Diesel

Approximately Newtonian under ordinary conditions.

#### Brake Fluid

Many common brake fluids can be treated approximately as Newtonian under normal operating conditions.

#### Engine Oil

Engine oils are often treated as Newtonian fluids in basic fluid mechanics problems.

However, actual engine oils can show more complex rheological behaviour depending on:

* Temperature
* Pressure
* Additives
* Shear rate

### ⭐ AMVI Point

For basic examination questions:

> **Water → Newtonian fluid**

is a very common example.

---

# 1.2.27 Non-Newtonian Fluid

A **non-Newtonian fluid** does not follow the simple Newton's law of viscosity.

In general:

$$
\boxed{\tau \not\propto \frac{du}{dy}}
$$

This means that shear stress is **not directly proportional** to velocity gradient.

The apparent viscosity can change with the flow/shear conditions.

---

# 1.2.28 Newtonian vs Non-Newtonian

| Property                  | Newtonian Fluid                               | Non-Newtonian Fluid                       |
| ------------------------- | --------------------------------------------- | ----------------------------------------- |
| Newton's law of viscosity | Follows                                       | Does not follow simple Newtonian relation |
| Relationship              | $\tau \propto du/dy$                          | $\tau \not\propto du/dy$                  |
| Viscosity                 | Approximately constant at a given temperature | May change with shear conditions          |
| $\tau$ vs $du/dy$ graph   | Straight line                                 | Generally non-linear                      |
| Flow behaviour            | Relatively simple                             | More complex                              |
| Examples                  | Water, air, petrol                            | Ketchup, toothpaste, paint                |

---

# 1.2.29 Examples of Non-Newtonian Fluids

Examples include:

* Ketchup
* Toothpaste
* Paint
* Blood
* Mayonnaise
* Mud
* Cement slurry
* Chocolate
* Shampoo
* Printing ink
* Some polymer solutions
* Many greases

---

# 1.2.30 Important Types of Non-Newtonian Fluids

For AMVI, the following types are useful to know:

```text
                    NON-NEWTONIAN FLUIDS
                              │
              ┌───────────────┼───────────────┐
              │               │               │
         Pseudoplastic     Dilatant       Bingham Plastic
         (Shear-thinning) (Shear-thickening) (Yield stress)
```

The three important categories are:

1. **Pseudoplastic**
2. **Dilatant**
3. **Bingham Plastic**

---

# 1.2.31 Pseudoplastic Fluid

A **pseudoplastic fluid** is also called a:

> **Shear-thinning fluid**

Its apparent viscosity **decreases as shear rate increases**.

```text
Shear rate ↑
     ↓
Apparent viscosity ↓
```

### Examples

* Ketchup
* Paint
* Blood
* Some polymer solutions

### Example: Ketchup

Ketchup may not flow easily initially.

When shaken or squeezed:

```text
Shear increases
      ↓
Apparent viscosity decreases
      ↓
Ketchup flows more easily
```

### ⭐ AMVI Memory

> **Pseudoplastic = Shear-thinning**

> **More shear → Less apparent viscosity**

---

# 1.2.32 Dilatant Fluid

A **dilatant fluid** is also called a:

> **Shear-thickening fluid**

Its apparent viscosity **increases as shear rate increases**.

```text
Shear rate ↑
     ↓
Apparent viscosity ↑
```

### Example

A mixture of:

> **Cornstarch + Water**

can exhibit shear-thickening behaviour.

If slowly disturbed:

```text
Low shear
   ↓
Flows relatively easily
```

If suddenly subjected to high shear:

```text
High shear
   ↓
Apparent viscosity increases
   ↓
Becomes much more resistant to deformation
```

### ⭐ AMVI Memory

> **Dilatant = Shear-thickening**

> **More shear → More apparent viscosity**

---

# 1.2.33 Bingham Plastic Fluid

A **Bingham plastic** is a material that requires a certain minimum stress before it begins to flow.

This minimum stress is called:

> **Yield stress**

```text
Applied stress
      ↓
Below yield stress
      ↓
No continuous flow
      ↓
Yield stress exceeded
      ↓
Flow begins
```

### Examples

* Toothpaste
* Some drilling muds
* Some slurries
* Certain pastes

### Example: Toothpaste

When toothpaste is inside the tube:

```text
No sufficient stress
       ↓
Toothpaste does not flow
```

When you squeeze the tube:

```text
Applied stress
       ↓
Yield stress exceeded
       ↓
Toothpaste flows
```

### ⭐ AMVI Memory

> **Bingham plastic → Yield stress required before flow**

---

# 1.2.34 Comparison of Non-Newtonian Types

| Type            | Other Name         | Behaviour when Shear Rate Increases        | Example                   |
| --------------- | ------------------ | ------------------------------------------ | ------------------------- |
| Pseudoplastic   | Shear-thinning     | Apparent viscosity decreases               | Ketchup, paint            |
| Dilatant        | Shear-thickening   | Apparent viscosity increases               | Cornstarch + water        |
| Bingham Plastic | Yield-stress fluid | Flow begins after yield stress is exceeded | Toothpaste, some slurries |

---

# 1.2.35 Complete Classification of Fluids

```text
                              FLUIDS
                                 │
                ┌────────────────┴────────────────┐
                │                                 │
       Based on Idealization              Based on Viscous
                │                              Behaviour
        ┌───────┴───────┐                ┌──────┴──────┐
        │               │                │             │
      Ideal            Real          Newtonian    Non-Newtonian
      Fluid            Fluid            Fluid          Fluid
                                                    │
                                      ┌─────────────┼─────────────┐
                                      │             │             │
                                 Pseudoplastic   Dilatant     Bingham
                                 Shear-thinning Shear-thickening Plastic
```

---

# 1.2.36 Very Important: These Classifications Are Different

This is one of the most important concepts in this topic.

## Classification 1: Ideal vs Real

This mainly considers:

> **Viscosity and idealization**

```text
Ideal
  ↓
μ = 0

Real
  ↓
μ > 0
```

---

## Classification 2: Newtonian vs Non-Newtonian

This considers:

> **Relationship between shear stress and velocity gradient**

```text
Newtonian
    ↓
τ = μ(du/dy)

Non-Newtonian
    ↓
Does not follow the simple Newtonian relationship
```

---

# 1.2.37 Example: Water

Water can be described as:

> **Real + Approximately Newtonian + Approximately incompressible**

Why?

```text
Water
 │
 ├── Real fluid
 │     └── Has viscosity
 │
 ├── Approximately Newtonian
 │     └── Follows Newton's law approximately
 │
 └── Approximately incompressible
       └── Density changes very little under ordinary
           liquid-flow pressure variations
```

---

# 1.2.38 Example: Ketchup

Ketchup can be described as:

> **Real + Non-Newtonian + Pseudoplastic**

```text
Ketchup
 │
 ├── Real fluid
 │     └── Has viscosity
 │
 ├── Non-Newtonian
 │     └── Does not follow simple Newtonian behaviour
 │
 └── Pseudoplastic
       └── Shear-thinning behaviour
```

---

# 1.2.39 Example: Cornstarch + Water

Cornstarch-water suspension can exhibit:

> **Real + Non-Newtonian + Dilatant**

```text
Cornstarch + Water
 │
 ├── Real fluid/material
 │
 ├── Non-Newtonian
 │
 └── Dilatant
       └── Shear-thickening behaviour
```

---

# 1.2.40 Ideal vs Newtonian — Do Not Confuse

These terms do **not** mean the same thing.

### Ideal Fluid

Concerned with the assumption:

$$
\mu = 0
$$

and, in standard fluid mechanics, also:

$$
\rho = \text{constant}
$$

### Newtonian Fluid

Concerned with:

$$
\boxed{\tau = \mu\frac{du}{dy}}
$$

Therefore:

> **Ideal/Real** and **Newtonian/Non-Newtonian** are separate classifications.

---

# 1.2.41 Important AMVI Examples

| Fluid/Material     | Classification                                              |
| ------------------ | ----------------------------------------------------------- |
| Ideal fluid        | Hypothetical, incompressible and non-viscous                |
| Water              | Real, approximately Newtonian                               |
| Air                | Real, approximately Newtonian                               |
| Petrol             | Real, approximately Newtonian                               |
| Diesel             | Real, approximately Newtonian                               |
| Kerosene           | Real, approximately Newtonian                               |
| Glycerin           | Real, approximately Newtonian                               |
| Engine oil         | Real, often treated as Newtonian in basic problems          |
| Ketchup            | Real, non-Newtonian, pseudoplastic                          |
| Paint              | Real, commonly treated as non-Newtonian in basic examples   |
| Blood              | Real, non-Newtonian                                         |
| Toothpaste         | Real, yield-stress / Bingham-type example                   |
| Mayonnaise         | Real, non-Newtonian                                         |
| Cornstarch + water | Real, non-Newtonian, dilatant                               |
| Grease             | Real, generally non-Newtonian/complex rheological behaviour |

---

# 🧠 1.2.42 AMVI Important Points

Remember these:

1. **Ideal fluid = Incompressible + Non-viscous**

$$
\boxed{\rho = \text{constant},\quad \mu = 0}
$$

2. Ideal fluid is a **hypothetical fluid**.

3. A **real fluid has viscosity**.

$$
\boxed{\mu > 0}
$$

4. Real fluids exist in nature.

5. **Newtonian fluid follows Newton's law of viscosity.**

$$
\boxed{\tau = \mu\frac{du}{dy}}
$$

6. For a Newtonian fluid:

$$
\boxed{\tau \propto \frac{du}{dy}}
$$

7. At a given temperature, the viscosity of a Newtonian fluid is approximately constant.

8. **Non-Newtonian fluids do not follow the simple Newtonian relationship.**

9. **Pseudoplastic = Shear-thinning**

10. **Dilatant = Shear-thickening**

11. **Bingham plastic = Yield stress required before flow.**

12. Water is a common example of an **approximately Newtonian fluid**.

13. Ketchup is a common example of a **pseudoplastic fluid**.

14. Cornstarch + water is a common example of a **dilatant fluid**.

15. Toothpaste is commonly used as a **yield-stress/Bingham-type example**.

16. **Ideal/Real** and **Newtonian/Non-Newtonian** are different classifications.

---

# ⚠️ 1.2.43 Common AMVI Traps

### Trap 1

**Question:** Ideal fluid means only zero viscosity.

**Answer:** ❌ Incomplete.

For standard fluid mechanics:

$$
\boxed{\text{Ideal fluid = Incompressible + Non-viscous}}
$$

---

### Trap 2

**Question:** Water is an ideal fluid.

**Answer:** ❌ False.

Water is a **real fluid**, although it is often treated as approximately incompressible and approximately Newtonian.

---

### Trap 3

**Question:** All real fluids are non-Newtonian.

**Answer:** ❌ False.

Water is:

> Real + Approximately Newtonian

---

### Trap 4

**Question:** Newtonian fluid means zero viscosity.

**Answer:** ❌ False.

A Newtonian fluid can have viscosity.

Example:

> Water has viscosity and is approximately Newtonian.

---

### Trap 5

**Question:** Non-Newtonian means non-viscous.

**Answer:** ❌ False.

Non-Newtonian fluids generally **have viscosity**; their viscosity does not behave as a constant in the simple Newtonian sense.

---

# 📝 1.2.44 Quick MCQs

## Q1. An ideal fluid is assumed to be:

A. Compressible and viscous
B. Incompressible and viscous
C. Compressible and non-viscous
D. Incompressible and non-viscous

**Answer: D. Incompressible and non-viscous**

---

## Q2. For an ideal fluid, dynamic viscosity is:

A. Zero
B. One
C. Infinite
D. Variable

**Answer: A. Zero**

---

## Q3. Which of the following is a real fluid?

A. Hypothetical inviscid fluid
B. Water
C. Perfect fluid
D. Zero-viscosity fluid

**Answer: B. Water**

---

## Q4. A Newtonian fluid obeys:

A. Pascal's law
B. Newton's law of viscosity
C. Boyle's law
D. Hooke's law

**Answer: B. Newton's law of viscosity**

---

## Q5. For a Newtonian fluid:

A. $\tau$ is directly proportional to velocity gradient

B. $\tau$ is inversely proportional to velocity gradient

C. $\tau$ is always zero

D. $\tau$ is independent of velocity gradient

**Answer: A. $\tau$ is directly proportional to velocity gradient**

---

## Q6. Which of the following is approximately a Newtonian fluid?

A. Ketchup
B. Toothpaste
C. Water
D. Cornstarch-water mixture

**Answer: C. Water**

---

## Q7. A shear-thinning fluid is called:

A. Dilatant
B. Pseudoplastic
C. Bingham plastic
D. Ideal

**Answer: B. Pseudoplastic**

---

## Q8. A shear-thickening fluid is called:

A. Pseudoplastic
B. Newtonian
C. Dilatant
D. Ideal

**Answer: C. Dilatant**

---

## Q9. Which type of fluid requires a yield stress before flow begins?

A. Ideal fluid
B. Newtonian fluid
C. Bingham plastic
D. Perfect gas

**Answer: C. Bingham plastic**

---

## Q10. Which of the following is a common example of a shear-thickening material?

A. Water
B. Air
C. Cornstarch-water mixture
D. Petrol

**Answer: C. Cornstarch-water mixture**

---

## Q11. The slope of the $\tau$ vs $\frac{du}{dy}$ graph for a Newtonian fluid represents:

A. Density
B. Specific gravity
C. Dynamic viscosity
D. Pressure

**Answer: C. Dynamic viscosity**

---

## Q12. Which statement is correct?

A. All real fluids are non-Newtonian

B. All Newtonian fluids are ideal

C. Real/ideal and Newtonian/non-Newtonian are different classifications

D. Water is an ideal fluid

**Answer: C. Real/ideal and Newtonian/non-Newtonian are different classifications**

---

# 🎯 1.2.45 Exam Revision Table

| Concept                 | Key Point                                               |
| ----------------------- | ------------------------------------------------------- |
| Ideal Fluid             | Hypothetical fluid                                      |
| Ideal Fluid             | Incompressible + non-viscous                            |
| Ideal Fluid             | $\rho$ constant and $\mu = 0$                           |
| Real Fluid              | Actual fluid having viscosity                           |
| Real Fluid              | $\mu > 0$                                               |
| Newtonian Fluid         | Follows Newton's law of viscosity                       |
| Newtonian Relation      | $\tau = \mu(du/dy)$                                     |
| Newtonian Fluid         | $\tau \propto du/dy$                                    |
| Newtonian Graph         | Straight line through origin                            |
| Pseudoplastic           | Shear-thinning                                          |
| Pseudoplastic           | Apparent viscosity decreases with increasing shear rate |
| Dilatant                | Shear-thickening                                        |
| Dilatant                | Apparent viscosity increases with increasing shear rate |
| Bingham Plastic         | Yield stress required before flow                       |
| Water                   | Approximately Newtonian                                 |
| Air                     | Approximately Newtonian                                 |
| Ketchup                 | Pseudoplastic                                           |
| Cornstarch + Water      | Dilatant                                                |
| Toothpaste              | Yield-stress / Bingham-type example                     |
| Ideal/Real              | One classification                                      |
| Newtonian/Non-Newtonian | Another classification                                  |

---

# 🔗 1.2.46 Topic Progress

```text
1. FLUIDS & THEIR PROPERTIES
│
├── ✅ 1.1 Fluid – Basic Concept
│
├── ✅ 1.2 Types of Fluid
│
├── ⏳ 1.3 Density
├── ⏳ 1.4 Specific Weight
├── ⏳ 1.5 Specific Volume
├── ⏳ 1.6 Specific Gravity
├── ⏳ 1.7 Viscosity
├── ⏳ 1.8 Dynamic Viscosity
├── ⏳ 1.9 Kinematic Viscosity
├── ⏳ 1.10 Newton's Law of Viscosity
├── ⏳ 1.11 Compressibility
└── ⏳ 1.12 Units & Dimensions
```
