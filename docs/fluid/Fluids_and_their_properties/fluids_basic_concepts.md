
# 1.1 Fluid – Basic Concept

## 📌 Syllabus Mapping

**Syllabus Keyword:** Fluids and Their Properties

**Topic:** 1.1 Fluid – Basic Concept

---

# 1.1.1 What is a Fluid?

A **fluid** is a substance that **deforms continuously when subjected to any shear stress, however small the shear stress may be**.

### Simple Definition

> A fluid cannot resist a continuous shear force. It keeps changing its shape and therefore flows.

### Examples

- Water
- Oil
- Petrol
- Diesel
- Air
- Steam

### ⭐ AMVI Point

Both **liquids and gases are fluids**.

---

# 1.1.2 Why Does a Fluid Flow?

A fluid flows because it cannot resist a continuous shear stress.

## Solid

When a tangential/shearing force is applied to a solid:

```text
       Force →
   ┌──────────┐
   │  SOLID   │
   └──────────┘
````

The solid may deform slightly, but it can resist the shear force and eventually reach equilibrium.

## Fluid

When a tangential/shearing force is applied to a fluid:

```text
       Force →
   ┌──────────┐
   │  FLUID   │  → → → Continuous deformation
   └──────────┘
```

A fluid continues to deform as long as shear stress is applied.

### ⭐ AMVI Point

**A fluid cannot sustain shear stress at rest.**

However:

* A **moving fluid can have shear stress** due to viscosity.
* A fluid at rest has **no shear stress**.

---

# 1.1.3 Fluid vs Solid

| Property                 | Solid                   | Fluid                               |
| ------------------------ | ----------------------- | ----------------------------------- |
| Shape                    | Definite shape          | No definite shape                   |
| Volume                   | Generally definite      | Liquid: definite; Gas: not definite |
| Response to shear stress | Can resist shear stress | Continuously deforms                |
| Flow                     | Does not flow           | Flows                               |
| Shear deformation        | Limited                 | Continuous                          |
| Examples                 | Steel, wood             | Water, air                          |

### ⭐ AMVI MCQ Trap

**Question:** Which of the following cannot resist shear stress continuously?

**Answer:** Fluid

---

# 1.1.4 Liquids and Gases

Both liquids and gases are fluids, but they have important differences.

| Property          | Liquid                   | Gas                    |
| ----------------- | ------------------------ | ---------------------- |
| Volume            | Nearly fixed             | Not fixed              |
| Shape             | Takes shape of container | Fills entire container |
| Compressibility   | Very low                 | High                   |
| Free surface      | Usually present          | No free surface        |
| Density           | Relatively high          | Relatively low         |
| Molecular spacing | Small                    | Large                  |

## Example

### Water

If **1 litre of water** is placed in a larger container:

* Water remains approximately 1 litre.
* It takes the shape of the container.

### Air

If air is placed in the same container:

* Air expands.
* It occupies the entire available volume.

---

# 1.1.5 Shear Stress

Understanding **shear stress** is important because it is used repeatedly in fluid mechanics.

Shear stress is the **tangential force acting per unit area**.

## Formula

$$
\tau = \frac{F}{A}
$$

Where:

* $\tau$ = shear stress
* $F$ = tangential/shearing force
* $A$ = area over which force acts

## SI Unit

$$
N/m^2
$$

or

$$
Pa
$$

where **Pa = Pascal**.

---

## Example 1

A tangential force of **100 N** acts on an area of **2 m²**.

Find the shear stress.

### Solution

$$
\tau = \frac{F}{A}
$$

$$
\tau = \frac{100}{2}
$$

$$
\boxed{\tau = 50\,Pa}
$$

### ⭐ AMVI MCQ

A shear force of **50 N** acts over an area of **5 m²**. The shear stress is:

A. 5 Pa
B. 10 Pa
C. 25 Pa
D. 250 Pa

**Answer: B. 10 Pa**

---

# 1.1.6 Shear Force

A force acting **parallel/tangential to a surface** is called a **shear force**.

```text
              F →
       ┌──────────────┐
       │              │
       │    Fluid     │
       │              │
       └──────────────┘
       ────────────────
            Surface
```

The force `F` is acting parallel to the surface.

Therefore, it produces **shearing action**.

### ⭐ Key Point

> **Shear force acts parallel to the surface.**

---

# 1.1.7 Normal Force vs Shear Force

This distinction is important for AMVI.

## Normal Force

A force acting **perpendicular** to a surface is called a normal force.

```text
             ↓ F
       ┌──────────────┐
       │    Fluid     │
       └──────────────┘
```

It produces **normal stress/pressure**.

## Shear Force

A force acting **parallel** to a surface is called a shear force.

```text
       F →
       ┌──────────────┐
       │    Fluid     │
       └──────────────┘
```

It produces **shear stress**.

| Force        | Direction     | Associated Quantity      |
| ------------ | ------------- | ------------------------ |
| Normal force | Perpendicular | Pressure / Normal stress |
| Shear force  | Parallel      | Shear stress             |

### ⭐ AMVI Shortcut

> **Normal → Perpendicular**

> **Shear → Parallel**

---

# 1.1.8 Why is Viscosity Important?

A common question is:

> If a fluid cannot resist shear stress, how can water or oil offer resistance when flowing?

The answer is **viscosity**.

### Definition

**Viscosity** is the property of a fluid that **opposes relative motion between adjacent layers of fluid**.

## Examples

### Water

Water flows relatively easily.

Therefore:

> Water → **Low viscosity**

### Honey

Honey flows slowly.

Therefore:

> Honey → **High viscosity**

```text
Low viscosity              High viscosity

Water                       Honey
  ↓                           ↓
Easy flow                   Difficult flow
```

### ⭐ AMVI Point

Viscosity will be studied in detail in:

* **1.7 Viscosity**
* **1.8 Dynamic Viscosity**
* **1.9 Kinematic Viscosity**
* **1.10 Newton's Law of Viscosity**

---

# 1.1.9 Fluid as a Continuum

Fluids are actually made up of a very large number of molecules.

```text
● ● ● ● ● ●
 ● ● ● ● ●
● ● ● ● ● ●
```

However, in ordinary fluid mechanics calculations, we do not analyze individual molecules.

Instead, we consider the fluid as a **continuous medium**.

This assumption is called the:

> **Continuum Assumption**

Under this assumption, properties such as:

* Density
* Pressure
* Temperature
* Velocity

are considered to vary continuously throughout the fluid.

### ⭐ AMVI Relevance

Usually asked as a **conceptual MCQ**.

---

# 1.1.10 Characteristics of a Fluid

Important characteristics of fluids are:

## 1. No Fixed Shape

A fluid takes the shape of its container.

## 2. Fluids Flow

Liquids and gases can move from one location to another.

## 3. Cannot Sustain Shear Stress at Rest

This is one of the **most important definitions** in fluid mechanics.

## 4. Liquids are Nearly Incompressible

Their volume changes very little when pressure changes.

## 5. Gases are Highly Compressible

Their volume can change significantly when pressure changes.

## 6. Fluids Have Viscosity

Viscosity causes resistance to relative motion between fluid layers.

---

# 1.1.11 Engineering Examples

Understanding fluids is important in automobile engineering.

## Engine Oil

**Fluid → Yes**

### Why?

It flows through the lubrication system and lubricates moving components.

---

## Petrol

**Fluid → Yes**

### Why?

It flows through fuel lines and the fuel injection system.

---

## Brake Fluid

**Fluid → Yes**

### Why?

It transmits hydraulic pressure from the brake master cylinder to the brake mechanism.

### Connection

This is directly related to:

> **Pascal's Law**

---

## Air

**Fluid → Yes**

Air flows through:

* Intake systems
* Exhaust systems
* Turbochargers
* Pneumatic systems

---

# 🧠 1.1 AMVI Important Points

Remember these points:

1. **Both liquids and gases are fluids.**

2. A fluid **continuously deforms under shear stress**.

3. A fluid **cannot sustain shear stress at rest**.

4. Shear stress is:

$$
\boxed{\tau = \frac{F}{A}}
$$

5. SI unit of shear stress:

$$
\boxed{Pa = N/m^2}
$$

6. Liquids are **nearly incompressible**.

7. Gases are **highly compressible**.

8. Viscosity causes resistance to relative motion between fluid layers.

9. A fluid has **no fixed shape**.

10. Continuum assumption treats a fluid as a **continuous medium**.

---

# 📝 Quick MCQs

## Q1. Which of the following is a fluid?

A. Steel
B. Wood
C. Water
D. Glass

**Answer: C. Water**

---

## Q2. Which of the following is also considered a fluid?

A. Air
B. Steel
C. Copper
D. Aluminium

**Answer: A. Air**

---

## Q3. A fluid at rest cannot sustain:

A. Pressure
B. Normal stress
C. Shear stress
D. Atmospheric pressure

**Answer: C. Shear stress**

---

## Q4. The SI unit of shear stress is:

A. N
B. N/m
C. N/m²
D. m²/N

**Answer: C. N/m²**

---

## Q5. Which statement is correct?

A. Only liquids are fluids

B. Only gases are fluids

C. Both liquids and gases are fluids

D. Solids and liquids are fluids

**Answer: C. Both liquids and gases are fluids**

---

## Q6. Which fluid is generally more compressible?

A. Water

B. Oil

C. Gas

D. Mercury

**Answer: C. Gas**

---

# 🎯 1.1 Exam Revision Table

| Concept                 | Key Point                                          |
| ----------------------- | -------------------------------------------------- |
| Fluid                   | Continuously deforms under shear stress            |
| Fluid at rest           | Cannot sustain shear stress                        |
| Liquid                  | Nearly incompressible                              |
| Gas                     | Highly compressible                                |
| Shear force             | Acts parallel to surface                           |
| Normal force            | Acts perpendicular to surface                      |
| Shear stress            | $\tau = F/A$                                       |
| SI unit of shear stress | Pa or N/m²                                         |
| Viscosity               | Resistance to relative motion between fluid layers |
| Continuum               | Fluid treated as a continuous medium               |

---

# 🔗 Topic Progress

```text
1. FLUIDS & THEIR PROPERTIES
│
├── ✅ 1.1 Fluid – Basic Concept
│
├── ⏳ 1.2 Types of Fluid
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

---

# ✅ 1.1 Completion Checklist

* [x] Definition of fluid
* [x] Why fluids flow
* [x] Fluid vs solid
* [x] Liquid vs gas
* [x] Shear stress
* [x] Shear force
* [x] Normal force vs shear force
* [x] Basic concept of viscosity
* [x] Continuum assumption
* [x] Characteristics of fluids
* [x] Automobile engineering examples
* [x] AMVI important points
* [x] Basic numerical
* [x] AMVI MCQs
* [x] Revision table

```
```
