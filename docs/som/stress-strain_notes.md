# 🔩 Strength of Materials --- Chapter 1: Simple Stress

## Complete Coverage

``` text
1.1  Load & Internal Resistance
       ↓
1.2  Stress
       ↓
1.3  Types of Stress
       ↓
1.4  Direct Stress
       ↓
1.5  Strain
       ↓
1.6  Types of Strain
       ↓
1.7  Hooke's Law
       ↓
1.8  Elasticity & Plasticity
       ↓
1.9  Proportional & Elastic Limit
       ↓
1.10 Stress-Strain Curve
       ↓
1.11 Poisson's Ratio
       ↓
1.12 Thermal Stress & Strain
       ↓
1.13 Elastic Constants
       ↓
1.14 Relations Between Elastic Constants
```

------------------------------------------------------------------------

# 1. Load & Internal Resistance

## 1. Load

A **load** is an external force or system of forces applied to a body.

Examples:

-   Pulling a rod
-   Compressing a column
-   Weight acting on a beam
-   Force acting on a machine component

The SI unit of force/load is:

$$
\boxed{N}
$$

Common engineering units:

$$
1\,kN=1000\,N
$$

$$
1\,MN=10^6\,N
$$


## 2. Internal Resistance

When an external load is applied to a body, the particles inside the
material resist the deformation.

This resistance is called **internal resistance**.

The basic sequence is:

$$
\boxed{
\text{External Load}
\rightarrow
\text{Deformation tendency}
\rightarrow
\text{Internal Resistance}
}
$$

This internal resistance is the basis for defining **stress**.

### AMVI Point

**External load** acts on the body from outside.

**Internal resistance** develops inside the body in response to the
external load.

------------------------------------------------------------------------

## 3. Unit Conversions



**Stress** is the internal resisting force developed per unit
cross-sectional area of a loaded body.

$$
\boxed{\sigma=\frac{P}{A}}
$$

where:

-   $P$ = applied load
-   $A$ = cross-sectional area
-   $\sigma$ = stress

### Unit

SI:

$$
\boxed{N/m^2=Pa}
$$

Engineering:

$$
\boxed{N/mm^2=MPa}
$$

Important:

$$
\boxed{1\,N/mm^2=1\,MPa}
$$

### Dimensions

Stress:

$$
\frac{Force}{Area}
$$

$$
=\frac{MLT^{-2}}{L^2}
$$

Therefore:

$$
\boxed{[\sigma]=ML^{-1}T^{-2}}
$$


## 4. Most important conversion ⭐⭐⭐

The most important Strength of Materials conversion is:

$$
\boxed{1\ MPa = 1\ N/mm^2}
$$

Why?

$$
1\ MPa = 10^6\ Pa = 10^6\ N/m^2
$$

Also:

$$
1\ m^2 = 10^6\ mm^2
$$

Therefore:

$$
1\ N/mm^2 = 10^6\ N/m^2
$$

Hence:

$$
\boxed{1\ MPa = 1\ N/mm^2}
$$

---

#### MPa conversions

$$
\boxed{1\ MPa = 10^6\ Pa}
$$

$$
\boxed{1\ MPa = 10^6\ N/m^2}
$$

$$
\boxed{1\ MPa = 1\ N/mm^2}
$$

$$
\boxed{1\ MPa = 1000\ kPa}
$$

$$
\boxed{1\ MPa = 0.001\ GPa}
$$

##### Example

25 MPa:

$$
25\ MPa = 25\times10^6\ N/m^2
$$

$$
\boxed{25\ MPa = 25\ N/mm^2}
$$

---

#### GPa conversions

We know:

$$
1\ GPa = 10^9\ Pa
$$

Therefore:

$$
\boxed{1\ GPa = 10^9\ N/m^2}
$$

Since:

$$
1\ GPa = 1000\ MPa
$$

and:

$$
1\ MPa = 1\ N/mm^2
$$

therefore:

$$
\boxed{1\ GPa = 1000\ N/mm^2}
$$

#### Complete conversion

$$
\boxed{
1\ GPa =
1000\ MPa =
1000\ N/mm^2 =
10^9\ Pa =
10^9\ N/m^2
}
$$

---

#### Pa, kPa, MPa and GPa

| Unit | Equivalent in Pa |
|---|---:|
| 1 Pa | $1$ Pa |
| 1 kPa | $10^3$ Pa |
| 1 MPa | $10^6$ Pa |
| 1 GPa | $10^9$ Pa |

Therefore:

$$
\boxed{1\ GPa = 1000\ MPa = 1,000,000\ kPa}
$$

---

#### N/m² and N/mm² ⭐⭐⭐

Because:

$$
1\ m = 1000\ mm
$$

then:

$$
1\ m^2 = 10^6\ mm^2
$$

Therefore:

$$
\boxed{1\ N/mm^2 = 10^6\ N/m^2}
$$

and:

$$
\boxed{1\ N/m^2 = 10^{-6}\ N/mm^2}
$$

##### Example

Convert 5 N/mm² to N/m²:

$$
5\times10^6
$$

$$
\boxed{5\ N/mm^2 = 5\times10^6\ N/m^2}
$$

---

#### N/mm² ↔ MPa

This is the easiest conversion:

$$
\boxed{1\ N/mm^2 = 1\ MPa}
$$

Examples:

$$
50\ N/mm^2 = 50\ MPa
$$

$$
250\ N/mm^2 = 250\ MPa
$$

$$
0.5\ N/mm^2 = 0.5\ MPa
$$

---

#### GPa → MPa

Multiply by 1000.

Example:

$$
2.5\ GPa = 2.5\times1000\ MPa
$$

$$
\boxed{2.5\ GPa = 2500\ MPa}
$$

---

#### GPa → N/mm²

$$
2.5\ GPa
=
2.5\times1000\ N/mm^2
$$

$$
\boxed{2.5\ GPa = 2500\ N/mm^2}
$$

---

#### GPa → N/m²

$$
2.5\ GPa
=
2.5\times10^9\ N/m^2
$$

$$
\boxed{2.5\ GPa = 2.5\times10^9\ N/m^2}
$$

---

#### CGS unit of stress ⭐

Assuming you mean **CGS** (centimetre–gram–second):

- CGS force unit = **dyne**
- CGS stress unit = **dyne/cm²**

The basic relation is:

$$
\boxed{1\ Pa = 10\ dyne/cm^2}
$$

Therefore:

$$
\boxed{1\ MPa = 10^7\ dyne/cm^2}
$$

and:

$$
\boxed{1\ GPa = 10^{10}\ dyne/cm^2}
$$

Also:

$$
\boxed{1\ N/mm^2 = 10^7\ dyne/cm^2}
$$

---

#### Other common engineering stress units

### bar

$$
1\ bar = 10^5\ Pa
$$

Therefore:

$$
\boxed{1\ MPa = 10\ bar}
$$

---

### kgf/cm²

$$
1\ kgf/cm^2 \approx 98,066.5\ Pa
$$

Therefore:

$$
\boxed{1\ kgf/cm^2 \approx 0.0980665\ MPa}
$$

and:

$$
\boxed{1\ MPa \approx 10.1972\ kgf/cm^2}
$$

---

##### Standard atmosphere

$$
1\ atm = 101325\ Pa
$$

Therefore:

$$
\boxed{1\ atm = 0.101325\ MPa}
$$

and approximately:

$$
\boxed{1\ MPa = 9.869\ atm}
$$

---

##### psi

$$
1\ psi \approx 6894.76\ Pa
$$

Therefore:

$$
\boxed{1\ MPa \approx 145.038\ psi}
$$


#### Example

A rod has:

$$
P=20\,kN
$$

$$
A=500\,mm^2
$$

Then:

$$
\sigma=\frac{20,000}{500}
$$

$$
\boxed{\sigma=40\,N/mm^2=40\,MPa}
$$

### Important relationship

For constant load:

$$
\sigma\propto\frac{1}{A}
$$

Therefore:

$$
A\uparrow\Rightarrow\sigma\downarrow
$$

------------------------------------------------------------------------
# 2. Stress Tensor

### 2.1 What is Stress?

Stress describes the internal force intensity developed inside a body when external loading acts on it.

For simple axial loading:

$$
\sigma=\frac{P}{A}
$$

However, in a general 3D stress state, stress cannot be represented by only one number. The complete stress state at a point is represented by a **second-order tensor**.

### AMVI Point

> **Stress is a second-order tensor.**

---

### 2.2 3D Stress Tensor
## Components of Stress Tensor

<p align="center">
  <img src="Components_of_Stress_Tensor.png" alt="Components of Stress Tensor" width="450">
</p>
The general 3D stress tensor can be written as:

$$
[\sigma]=
\begin{bmatrix}
\sigma_{xx} & \tau_{xy} & \tau_{xz}\\
\tau_{yx} & \sigma_{yy} & \tau_{yz}\\
\tau_{zx} & \tau_{zy} & \sigma_{zz}
\end{bmatrix}
$$

There are initially **9 entries** in this matrix:

- 3 normal-stress components
- 6 shear-stress components

### 2.3 Normal stresses

$$
\sigma_{xx},\quad \sigma_{yy},\quad \sigma_{zz}
$$

These act normal/perpendicular to the corresponding faces.

### 2.4 Shear stresses

$$
\tau_{xy},\quad \tau_{xz},\quad \tau_{yx},\quad \tau_{yz},\quad \tau_{zx},\quad \tau_{zy}
$$

These act tangentially to the corresponding faces.

---

### 2.5 Are There 9 or 6 Independent Stress Components?

 This is an important point from the source notes.\
 General Matrix Has 9 Components


$$
3\text{ normal}+6\text{ shear}=9
$$

But for the **ordinary Cauchy stress tensor in classical continuum mechanics**, the tensor is symmetric when there are no couple stresses/body moments.

Therefore:

$$
\tau_{xy}=\tau_{yx}
$$

$$
\tau_{xz}=\tau_{zx}
$$

$$
\tau_{yz}=\tau_{zy}
$$

So only 6 values are independent:

$$
\boxed{3\text{ normal}+3\text{ independent shear}=6}
$$

The symmetric form is:

$$
[\sigma]=
\begin{bmatrix}
\sigma_x & \tau_{xy} & \tau_{xz}\\
\tau_{xy} & \sigma_y & \tau_{yz}\\
\tau_{xz} & \tau_{yz} & \sigma_z
\end{bmatrix}
$$

### Why are only 6 independent?

The equality of complementary shear components follows from **moment equilibrium / conservation of angular momentum** for the classical Cauchy stress tensor.

### AMVI-MPSC Key Point

> **1. A 3D classical Cauchy stress tensor has 6 independent components: 3 normal + 3 shear.**

> **2. If I want to define stress tranfer in 3D, I required 6 stress only. [3 Normal and 3 Shear]**

---

### 2.6 ⚠️ Correction / Clarification to the Source Notes

The source notes show the complementary shear stresses as equal in magnitude and opposite in direction and write, for example:

$$
\tau_{xy}=-\tau_{yx}
$$

This wording can be confusing if it is interpreted as a relationship between the **tensor components**.

For the standard Cauchy stress tensor, the component relationship is:

$$
\boxed{\tau_{xy}=\tau_{yx}}
$$

and similarly:

$$
\boxed{\tau_{xz}=\tau_{zx}}
$$

$$
\boxed{\tau_{yz}=\tau_{zy}}
$$

### Why does the source show opposite directions?

On opposite faces of a small element, the actual **traction vectors** must act in opposite directions for force equilibrium. The outward normals of opposite faces are also opposite.

That directional picture should **not** be confused with the equality of the corresponding stress-tensor components.

### Exam Rule

> If the question asks for the **independent components of the classical 3D stress tensor**, answer **6**.

---

# 3. Stress Tensor vs Force vs Traction

These three ideas should not be mixed.

| Quantity | Meaning | Type |
|---|---|---|
| Force | External/internal resultant force | Vector |
| Traction | Force per unit area acting on a specified plane | Vector |
| Stress tensor | Complete stress state at a point | Second-order tensor |

For a specified plane with unit normal vector $n$, the traction vector is related to the stress tensor by:

$$
\mathbf{t}=\boldsymbol{\sigma}\mathbf{n}
$$

### AMVI Memory

> **Force → Vector**  
> **Traction on a plane → Vector**  
> **Complete stress state → Tensor**

---
# 4 Types of Stress

                         STRESS
                           │
             ┌─────────────┴─────────────┐
             │                           │
       NORMAL STRESS               SHEAR STRESS
             │                           │
       ┌─────┴─────┐                     │
       │           │                     │
    TENSILE    COMPRESSIVE             SHEAR

The basic types are:
1. Normal Stress - Perpendicular to Surface
2. Shear Stress - Parallel to Surface

------------------------------------------------------------------------

## 4.1 Tensile Stress

A pulling force produces tensile stress.

``` text
← P   |────────────|   P →
```

The body tends to elongate.

$$
\boxed{\sigma_t=\frac{P}{A}}
$$

Effects:

-   Length increases
-   Tensile deformation occurs
-   Tensile strain develops

------------------------------------------------------------------------

## 4.2 Compressive Stress

A pushing force produces compressive stress.

``` text
P →   |────────────|   ← P
```

The body tends to shorten.

$$
\boxed{\sigma_c=\frac{P}{A}}
$$

Effects:

-   Length decreases
-   Compressive deformation occurs
-   Compressive strain develops

------------------------------------------------------------------------

## 4.3 Shear Stress

When a tangential force attempts to make one layer of a material slide
relative to another, shear stress develops.

$$
\boxed{\tau=\frac{P}{A}}
$$

where $P$ is the shear force.

### Important distinction

| Normal Stress       | Shear Stress              |
| ------------------- | ------------------------- |
| Acts normal to area | Acts tangentially to area |
| Tensile             | Shear                     |
| Compressive         | Shear                     |

Thus:

$$
\boxed{\text{Tensile + Compressive = Normal/Direct stress}}
$$

------------------------------------------------------------------------

## 4.4 Direct Stress

Direct stress is stress produced by a force acting **along the
longitudinal axis** of a member.

It can be:

-   Tensile direct stress
-   Compressive direct stress

$$
\boxed{\sigma=\frac{P}{A}}
$$

### Example

A straight rod carrying an axial pulling force → tensile direct stress.

A column carrying an axial compressive force → compressive direct
stress.

### AMVI terminology

**Axial load = Direct load** in the basic/simple-stress context.

------------------------------------------------------------------------

# 5 Strain

Now connect this to stress.

When load produces stress, the body undergoes deformation.

**Strain measures this deformation relative to the original dimension.**

For longitudinal deformation:

$$
\boxed{\varepsilon=\frac{\Delta L}{L}}
$$

where:

-   $\Delta L$ = change in length
-   $L$ = original length

------------------------------------------------------------------------

## Unit of Strain

Since:

$$
\frac{mm}{mm}=1
$$

strain has:

$$
\boxed{\text{No unit}}
$$

It is dimensionless.

It may be expressed as:

-   mm/mm
-   m/m
-   percentage

### Percentage strain

$$
\boxed{\varepsilon_{\%}=\frac{\Delta L}{L}\times100}
$$

------------------------------------------------------------------------

## Example

Original length:

$$
L=1000\,mm
$$

Extension:

$$
\Delta L=2\,mm
$$

Therefore:

$$
\varepsilon=\frac{2}{1000}
$$

$$
\boxed{\varepsilon=0.002}
$$

or:

$$
\boxed{0.2\%}
$$

------------------------------------------------------------------------

# 5.1 Types of Strain

There are four important types.

## 5.1.1 Longitudinal Strain

Change in length/original length:

$$
\boxed{\varepsilon_L=\frac{\Delta L}{L}}
$$

It can be:

-   Tensile strain
-   Compressive strain

------------------------------------------------------------------------

## 5.1.2 Lateral Strain

When a rod is subjected to tensile load:

-   Length increases
-   Diameter decreases

The change in lateral dimension relative to original lateral dimension
is **lateral strain**.

$$
\boxed{\varepsilon_{lat}=\frac{\Delta d}{d}}
$$

------------------------------------------------------------------------

## 5.1.3 Shear Strain

Shear loading changes the angular shape of the body.

Shear strain is represented by:

$$
\boxed{\gamma}
$$

For small deformation:

$$
\boxed{\gamma\approx\phi}
$$

where $\phi$ is the angular deformation in radians.

------------------------------------------------------------------------

## 5.1.4 Volumetric Strain

Change in volume/original volume:

$$
\boxed{\varepsilon_v=\frac{\Delta V}{V}}
$$

------------------------------------------------------------------------

## Quick Table



| **Strain**   | **Formula**          | **Represents**                 |
|--------------|----------------------|--------------------------------|
| Longitudinal | $\Delta L/L$         | Change in length               |
| Lateral      | $\Delta d/d$         | Change in lateral dimension    |
| Shear        | $\gamma\approx\phi$  | Angular deformation            |
| Volumetric   | $\Delta V/V$         | Change in volume               |

## 5.2 Hooke's Law

This is one of the most important concepts in SOM.

### Statement

> Within the proportional limit, stress is directly proportional to
> strain.

$$
\boxed{\sigma\propto\varepsilon}
$$

Therefore:

$$
\boxed{\frac{\sigma}{\varepsilon}=constant}
$$

For normal stress, this constant is Young's modulus $E$:

$$
\boxed{E=\frac{\sigma}{\varepsilon}}
$$

Therefore:

$$
\boxed{\sigma=E\varepsilon}
$$

------------------------------------------------------------------------

## For Shear

Similarly:

$$
\boxed{\tau=G\gamma}
$$

where:

-   $G$ = modulus of rigidity
-   $\tau$ = shear stress
-   $\gamma$ = shear strain

## 5.3 Stress-Strain Curve
<p align="center">
  <img src="stress-strain-curve.png" alt="Components of Stress Tensor" width="450">
</p>

For a typical **mild steel/ductile material**, the important sequence
is:

## Stress–Strain Curve — Ductile Material


The curve plots:

* **Y-axis → Stress, $\sigma$**
* **X-axis → Strain, $\varepsilon$**

The typical curve can be understood in **six important stages**.

---

### 1. O → A : Linear / Proportional Region

At the beginning, the curve is almost a straight line.

Here:

$$
\sigma \propto \varepsilon
$$

Therefore, Hooke's law applies:

$$
\sigma=E\varepsilon
$$

where $E$ is Young's modulus.

**Point A = Proportional Limit**

At this point, stress is still proportional to strain.

> **AMVI:** Proportional limit = **end of linear relationship** between stress and strain.

---

### 2. A → B : Elastic Region

After the proportional limit, the curve may become slightly nonlinear.

However, the material can still return to its original shape if the load is removed.

**Point B = Elastic Limit**

At or below the elastic limit:

> **No permanent deformation remains after unloading.**

So:

```text
O → B  = Elastic region
Beyond B = Plastic deformation begins
```

### Important difference

| Proportional Limit                             | Elastic Limit                                  |
| ---------------------------------------------- | ---------------------------------------------- |
| End of linear behavior                         | End of elastic behavior                        |
| Stress proportional to strain up to this point | Complete recovery is possible up to this point |
| Usually occurs first                           | Usually slightly higher                        |

Therefore, for a typical ductile material:

$$
\boxed{\text{Proportional Limit < Elastic Limit}}
$$

---

### 3. B → C → D : Yielding Region

After the elastic limit, the material begins to undergo **permanent deformation**.

For mild steel, we commonly see:

* **Upper Yield Point (C)**
* **Lower Yield Point (D)**

The stress may actually drop after reaching the upper yield point.

This means the material can continue deforming considerably without a corresponding increase in stress.

### Key idea

> **Yielding = large plastic strain occurs with relatively little change in stress.**

For AMVI, remember:

```text
Upper Yield Point
       ↓
Stress drops
       ↓
Lower Yield Point
       ↓
Plastic deformation continues
```

---

### 4. D → E : Strain Hardening Region

After yielding, the material continues to deform plastically.

But now, more stress is required to continue deformation.

This is called **strain hardening** or **work hardening**.

The curve rises again.

Eventually it reaches point **E**.

---

### 5. Point E : Ultimate Tensile Strength (UTS)

Point E represents the **maximum engineering stress** reached during the tensile test.

$$
\boxed{\text{UTS}=\frac{\text{Maximum Load}}{\text{Original Cross-sectional Area}}}
$$

This is a very important MCQ point.

> **UTS = maximum engineering stress on the stress–strain curve.**

After UTS, the engineering stress starts decreasing.

---

### 6. E → F : Necking and Fracture

After UTS, **necking** begins in a typical ductile tensile specimen.

The cross-sectional area becomes locally smaller at one region.

Because engineering stress is calculated using the **original area**, the engineering stress shown on the graph decreases.

Eventually the specimen breaks.

**Point F = Fracture / Breaking Point**

---

# Complete Curve in One Flow

```text
O
│
│  Linear region
│      ↓
│  Proportional Limit
│      ↓
│  Elastic Limit
│      ↓
│  Upper Yield Point
│      ↓
│  Lower Yield Point
│      ↓
│  Strain Hardening
│      ↓
│  UTS
│      ↓
│  Necking
│      ↓
│  Fracture
└────────────────────→ Strain
```

## Most Important AMVI-MPSC Memory Map

| Point/Region | What happens              |
| ------------ | ------------------------- |
| **O**        | Origin                    |
| **A**        | Proportional limit        |
| **B**        | Elastic limit             |
| **C**        | Upper yield point         |
| **D**        | Lower yield point         |
| **D → E**    | Strain hardening          |
| **E**        | Ultimate tensile strength |
| **E → F**    | Necking                   |
| **F**        | Fracture                  |

### 🔥 5 One-Liner MCQ Facts

1. **Slope of initial straight portion = Young's modulus $E$.**
2. **Proportional limit → end of linear behavior.**
3. **Elastic limit → end of elastic behavior.**
4. **UTS → maximum engineering stress.**
5. **Fracture → specimen finally breaks.**

### One concept you should remember

**Elastic deformation is recoverable; plastic deformation is permanent.**

So the most important boundary on this curve is:

$$
\boxed{\text{Elastic Limit}}
$$

> #### Beyond the elastic limit, **permanent deformation remains even after removing the load**.
------------------------------------------------------------------------

## 🔥 Sequence for MCQ

$$
\boxed{
\text{Proportional Limit}
\rightarrow
\text{Elastic Limit}
\rightarrow
\text{Yield}
\rightarrow
\text{Strain Hardening}
\rightarrow
\text{Ultimate Stress}
\rightarrow
\text{Necking}
\rightarrow
\text{Fracture}
}
$$

------------------------------------------------------------------------
## 5.4 Elasticity & Plasticity

## 5.4.1 Elasticity

Ability of a material to regain its original dimensions after removal of
load.

$$
\boxed{\text{Load removed}\rightarrow\text{Original dimensions}}
$$

Example: spring under normal elastic loading.

------------------------------------------------------------------------

## 5.4.2 Plasticity

Ability of a material to undergo permanent deformation.

After removing the load:

$$
\boxed{\text{Permanent deformation remains}}
$$

### Comparison
| **Elastic Deformation**       | **Plastic Deformation**          |
|-------------------------------|-----------------------------------|
| Temporary                     | Permanent                         |
| Original shape recovered      | Original shape not fully recovered |
| Within elastic range          | Beyond elastic limit              |



## 5.4.3 Proportional Limit & Elastic Limit

These two are frequently confused.

### Proportional Limit

The maximum stress up to which:

$$
\boxed{\sigma\propto\varepsilon}
$$

That means the stress-strain graph remains linear.

------------------------------------------------------------------------

### Elastic Limit

The maximum stress up to which the material completely regains its
original dimensions after removal of load.

Beyond elastic limit:

$$
\boxed{\text{Permanent deformation occurs}}
$$

### Difference

| **Proportional Limit**             | **Elastic Limit**                    |
|------------------------------------|--------------------------------------|
| Stress proportional to strain      | Complete recovery after unloading    |
| Defines end of linear behaviour     | Defines end of elastic behaviour     |
| Usually occurs first               | Usually slightly higher              |

**Proportional Limit < Elastic Limit** -> For **Ductile Material**
> **Note:** For a typical ductile material, the proportional limit usually occurs slightly before the elastic limit.

$$
\boxed{\text{Proportional Limit}<\text{Elastic Limit}}
$$


# 1.11 Poisson's Ratio

When a bar is subjected to tensile load:

-   Length increases
-   Diameter decreases

Therefore, two strains are produced:

**Longitudinal strain**

and

**Lateral strain**

Poisson's ratio is defined as the ratio of lateral strain to
longitudinal strain.

$$
\boxed{\nu=-\frac{\text{Lateral strain}}{\text{Longitudinal strain}}}
$$

The negative sign is used because lateral and longitudinal strains have
opposite signs under tensile loading.

------------------------------------------------------------------------

## Example

Suppose:

$$
\text{Longitudinal strain}=0.002
$$

$$
\text{Lateral strain}=-0.0006
$$

Then:

$$
\nu=-\frac{-0.0006}{0.002}
$$

$$
\boxed{\nu=0.3}
$$

### Important

Poisson's ratio is:

$$
\boxed{\text{Dimensionless}}
$$

It has no unit.

------------------------------------------------------------------------

# 1.12 Thermal Stress & Strain

Temperature change can cause a body to expand or contract.

For a bar with original length $L$:

$$
\boxed{\Delta L=\alpha L\Delta T}
$$

where:

-   $\alpha$ = coefficient of linear expansion
-   $L$ = original length
-   $\Delta T$ = temperature change

Thermal strain:

$$
\boxed{\varepsilon_{th}=\alpha\Delta T}
$$

------------------------------------------------------------------------

## Free Expansion

Suppose a bar is free to expand:

``` text
Wall                         Free end

│────────────── Rod ───────────→
                              →
```

When temperature increases, the bar expands.

No restraint means:

$$
\boxed{\text{Thermal stress}=0}
$$

but:

$$
\boxed{\text{Thermal strain}\neq0}
$$

This is a **very important MCQ point**.

------------------------------------------------------------------------

## Fully Restrained Bar

Now suppose the bar cannot expand:

``` text
│──────────── Rod ────────────│
       Both ends fixed
```

Temperature increases.

The bar wants to expand but cannot.

Therefore thermal stress develops.

Thermal strain that would have occurred:

$$
\varepsilon_{th}=\alpha\Delta T
$$

Thermal stress:

$$
\boxed{\sigma_{th}=E\alpha\Delta T}
$$

For heating of a fully restrained bar, the stress is **compressive**.

For cooling of a fully restrained bar, the stress is **tensile**.

### 🔥 MCQ

**A freely expanding bar subjected to temperature rise develops:**

Answer:

$$
\boxed{\text{No thermal stress}}
$$

------------------------------------------------------------------------

# 1.13 Elastic Constants

There are four important elastic constants:

1.  Young's modulus --- $E$
2.  Modulus of rigidity --- $G$
3.  Bulk modulus --- $K$
4.  Poisson's ratio --- $\nu$

------------------------------------------------------------------------

## 1.13.1 Young's Modulus --- E

Ratio of normal stress to longitudinal strain:

$$
\boxed{E=\frac{\sigma}{\varepsilon}}
$$

It represents **stiffness against longitudinal deformation**.

Unit:

$$
\boxed{Pa,\;MPa,\;GPa}
$$

------------------------------------------------------------------------

## 1.13.2 Modulus of Rigidity --- G

Also called **Shear Modulus**.

Ratio of shear stress to shear strain:

$$
\boxed{G=\frac{\tau}{\gamma}}
$$

It represents resistance to **shear deformation**.

Unit:

$$
\boxed{Pa}
$$

------------------------------------------------------------------------

## 1.13.3 Bulk Modulus --- K

Bulk modulus measures resistance to **volume change**.

$$
\boxed{K=\frac{\text{Volumetric stress}}{\text{Volumetric strain}}}
$$

For hydrostatic pressure $p$:

$$
\boxed{K=-\frac{p}{\Delta V/V}}
$$

The negative sign is used because an increase in pressure normally
produces a decrease in volume.

Unit:

$$
\boxed{Pa}
$$

------------------------------------------------------------------------

## 1.13.4 Poisson's Ratio --- ν

$$
\boxed{\nu=-\frac{\text{Lateral strain}}{\text{Longitudinal strain}}}
$$

It is dimensionless.

------------------------------------------------------------------------

# 1.14 Relations Between Elastic Constants

This is an **extremely important AMVI formula section**.

For an isotropic, homogeneous, linearly elastic material:

## Relation between E, G and ν

$$
\boxed{E=2G(1+\nu)}
$$

Therefore:

$$
\boxed{G=\frac{E}{2(1+\nu)}}
$$

------------------------------------------------------------------------

## Relation between E, K and ν

$$
\boxed{E=3K(1-2\nu)}
$$

Therefore:

$$
\boxed{K=\frac{E}{3(1-2\nu)}}
$$

------------------------------------------------------------------------

## Relation between K, G and ν

$$
\boxed{K=\frac{2G(1+\nu)}{3(1-2\nu)}}
$$

------------------------------------------------------------------------

## Very Useful Combined Formula

From:

$$
E=2G(1+\nu)
$$

we get:

$$
\boxed{\nu=\frac{E}{2G}-1}
$$

And from:

$$
E=3K(1-2\nu)
$$

$$
\boxed{\nu=\frac{1}{2}\left(1-\frac{E}{3K}\right)}
$$

------------------------------------------------------------------------

# ⭐ AMVI Formula Sheet --- Simple Stress

  ----------------------------------------------------------------------------
  Concept                     Formula
  --------------------------- ------------------------------------------------
  Normal stress               $\boxed{\sigma=P/A}$

  Shear stress                $\boxed{\tau=P/A}$

  Longitudinal strain         $\boxed{\varepsilon=\Delta L/L}$

  Volumetric strain           $\boxed{\Delta V/V}$

  Shear strain                $\boxed{\gamma\approx\phi}$

  Hooke's law                 $\boxed{\sigma=E\varepsilon}$

  Shear Hooke's law           $\boxed{\tau=G\gamma}$

  Young's modulus             $\boxed{E=\sigma/\varepsilon}$

  Rigidity modulus            $\boxed{G=\tau/\gamma}$

  Poisson's ratio             $\boxed{\nu=-\varepsilon_{lat}/\varepsilon_L}$

  Thermal strain              $\boxed{\alpha\Delta T}$

  Thermal expansion           $\boxed{\Delta L=\alpha L\Delta T}$

  Fully restrained thermal    $\boxed{\sigma=E\alpha\Delta T}$
  stress                      

  Elastic constant relation   $\boxed{E=2G(1+\nu)}$

  Elastic constant relation   $\boxed{E=3K(1-2\nu)}$
  ----------------------------------------------------------------------------

------------------------------------------------------------------------

# 🚨 AMVI MCQ --- Must Remember

### 1. Stress has unit?

$$
\boxed{N/m^2=Pa}
$$

### 2. Engineering stress unit?

$$
\boxed{N/mm^2=MPa}
$$

### 3. Strain has unit?

$$
\boxed{\text{No unit}}
$$

### 4. Poisson's ratio has unit?

$$
\boxed{\text{No unit}}
$$

### 5. Young's modulus represents?

$$
\boxed{\text{Stiffness}}
$$

### 6. Hooke's law?

$$
\boxed{\sigma\propto\varepsilon}
$$

within proportional limit.

### 7. Maximum engineering stress?

$$
\boxed{\text{Ultimate tensile stress}}
$$

### 8. Necking starts after?

$$
\boxed{\text{Ultimate tensile stress}}
$$

### 9. Free thermal expansion produces?

$$
\boxed{\text{No thermal stress}}
$$

### 10. Fully restrained heating produces?

$$
\boxed{\text{Compressive thermal stress}}
$$

### 11. Fully restrained cooling produces?

$$
\boxed{\text{Tensile thermal stress}}
$$

### 12. Relation between E and G?

$$
\boxed{E=2G(1+\nu)}
$$

### 13. Relation between E and K?

$$
\boxed{E=3K(1-2\nu)}
$$

------------------------------------------------------------------------

# 📝 AMVI Practice MCQs

### Q1. Stress is defined as:

A. Force × area B. Force per unit area C. Deformation per unit length D.
Energy per unit volume

**Answer: B ✅**

------------------------------------------------------------------------

### Q2. Which quantity is dimensionless?

A. Stress B. Young's modulus C. Strain D. Force

**Answer: C ✅**

------------------------------------------------------------------------

### Q3. A tensile force causes:

A. Decrease in length B. Increase in length C. No deformation D. Only
angular deformation

**Answer: B ✅**

------------------------------------------------------------------------

### Q4. The slope of the initial straight portion of a stress-strain curve represents:

A. Toughness B. Young's modulus C. Yield stress D. Ultimate stress

**Answer: B ✅**

------------------------------------------------------------------------

### Q5. Hooke's law is valid up to:

A. Ultimate point B. Breaking point C. Proportional limit D. Necking
point

**Answer: C ✅**

------------------------------------------------------------------------

### Q6. Permanent deformation begins beyond:

A. Origin B. Elastic limit C. Proportional region only D. Ultimate point

**Answer: B ✅**

------------------------------------------------------------------------

### Q7. If the area of a bar is doubled while load remains constant, stress becomes:

A. Double B. Half C. Four times D. Unchanged

**Answer: B ✅**

------------------------------------------------------------------------

### Q8. The modulus of rigidity is:

A. Normal stress / longitudinal strain B. Shear stress / shear strain C.
Pressure / volume D. Load / area

**Answer: B ✅**

------------------------------------------------------------------------

### Q9. A freely expanding bar subjected to temperature rise develops:

A. Tensile thermal stress B. Compressive thermal stress C. Zero thermal
stress D. Shear stress

**Answer: C ✅**

------------------------------------------------------------------------

### Q10. For an isotropic material:

$$
E=?
$$

A. $G(1+\nu)$ B. $2G(1+\nu)$ C. $3G(1-\nu)$ D. $G/(1+\nu)$

**Answer: B ✅**

------------------------------------------------------------------------

### Q11. If $E=200\,GPa$ and $\nu=0.25$, find $G$.

$$
G=\frac{E}{2(1+\nu)}
$$

$$
G=\frac{200}{2(1.25)}
$$

$$
\boxed{G=80\,GPa}
$$

**Answer: 80 GPa ✅**

------------------------------------------------------------------------

### Q12. A fully restrained steel bar is heated. The thermal stress developed is:

A. Tensile B. Compressive C. Shear D. Zero

**Answer: B --- Compressive ✅**

------------------------------------------------------------------------

# 🎯 Chapter 1 --- Simple Stress: Completion Status

     No. Topic                                  Status
  ------ ------------------------------------- --------
     1.1 Load & Internal Resistance               ✅
     1.2 Stress                                   ✅
     1.3 Types of Stress                          ✅
     1.4 Direct Stress                            ✅
     1.5 Strain                                   ✅
     1.6 Types of Strain                          ✅
     1.7 Hooke's Law                              ✅
     1.8 Elasticity & Plasticity                  ✅
     1.9 Proportional & Elastic Limit             ✅
    1.10 Stress-Strain Curve                      ✅
    1.11 Poisson's Ratio                          ✅
    1.12 Thermal Stress & Strain                  ✅
    1.13 Elastic Constants                        ✅
    1.14 Relations Between Elastic Constants      ✅

**For our AMVI preparation, I would consider the basic theory covered,
but not the chapter fully mastered yet until we do a dedicated set of
formula-based, conceptual, and numerical MCQs.** The next major syllabus
keyword is **2. Strain Energy**.
