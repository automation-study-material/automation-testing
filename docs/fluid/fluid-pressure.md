
# AMVI – Hydraulics & Fluid Mechanics

# 4. FLUID PRESSURE – Complete MCQ-Oriented Notes

---

# 1.1 Pressure

## 1.1.1 Definition

**Pressure is the normal force acting per unit area.**

```math
P = \frac{F}{A}
```

Where:

* `P` = pressure
* `F` = normal force
* `A` = area

### Important

Pressure force acts **normal/perpendicular to the surface**.

```text
Draw:
Fluid element with pressure force acting normal to its surface.
```

---

## 1.1.2 Pressure in a Static Fluid

A very important AMVI concept:

> **In a fluid at rest, shear stress is zero, but normal stress is not zero.**

Why?

A fluid cannot sustain a shear stress when it is at rest. If a shear stress acts continuously, the fluid starts flowing.

However, the fluid can have **normal stress due to pressure**.

Therefore:

```text
Static fluid:

Shear stress (τ) = 0
Normal stress = Pressure ≠ 0
```

### ⭐ AMVI MCQ

**For a fluid at rest, which statement is correct?**

A. Shear stress = 0 and normal stress = 0
B. Shear stress ≠ 0 and normal stress = 0
C. Shear stress = 0 and normal stress ≠ 0
D. Both are always non-zero

**Answer: C** ✅

---

# 1.1.3 SI Unit

```text
Pressure = Pascal (Pa)
```

```math
1 Pa = 1 \frac{N}{m^2}
```

Important conversions:

```text
1 kPa = 10³ Pa
1 MPa = 10⁶ Pa
1 bar = 10⁵ Pa
```

Standard atmospheric pressure:

```text
1 atm ≈ 101.325 kPa
```

---

# 1.1.4 Dimension of Pressure

```math
[P] = ML^{-1}T^{-2}
```

### Remember

> **Pressure → `ML⁻¹T⁻²`**

---

# 1.2 Atmospheric Pressure

## 1.2.1 Definition

The atmosphere has weight. The weight of the atmospheric air produces pressure on the Earth's surface.

This is called:

> **Atmospheric pressure**

Symbol:

```text
Patm
```

---

## 1.2.2 Standard Atmospheric Pressure

At approximately sea level:

```text
Patm = 101325 Pa
     = 101.325 kPa
     ≈ 1.01325 bar
     = 760 mm Hg
     = 76 cm Hg
```

### ⭐ Remember

```text
1 atm
≈ 101.325 kPa
≈ 1.01325 bar
= 760 mm Hg
```

---

# 1.2.3 Measurement of Atmospheric Pressure

Atmospheric pressure is measured using a:

> **Barometer**

### Important distinction

```text
Barometer → Atmospheric pressure
Manometer → Pressure / pressure difference
Bourdon gauge → Pressure
```

### ⭐ MCQ

**Atmospheric pressure is measured by:**

A. Piezometer
B. Barometer
C. Bourdon gauge
D. Venturimeter

**Answer: B — Barometer** ✅

---

## 1.2.4 Atmospheric Pressure and Altitude

As altitude increases:

```text
Altitude ↑
    ↓
Atmospheric pressure ↓
```

Therefore atmospheric pressure is generally **maximum near sea level** compared with higher elevations.

---

# 1.3 Absolute Pressure

## Definition

Absolute pressure is measured from **perfect vacuum**.

Perfect vacuum is:

```text
Pabsolute = 0
```

Therefore absolute pressure is always:

```text
Pabs ≥ 0
```

---

## 1.3.1 Relation

For pressure above atmospheric:

```math
P_{abs}=P_{atm}+P_g
```

Therefore:

```math
P_g=P_{abs}-P_{atm}
```

---

# 1.4 Gauge Pressure

## Definition

> **Gauge pressure is pressure measured with respect to atmospheric pressure.**

This is one of the most important definitions for AMVI.

```math
P_g=P_{abs}-P_{atm}
```

---

## 1.4.1 Gauge Pressure Can Be Positive or Negative ⭐⭐⭐

Yes.

### Positive gauge pressure

When:

```text
Pabs > Patm
```

then:

```text
Pg > 0
```

Example:

```text
Patm = 100 kPa
Pabs = 250 kPa

Pg = 250 - 100
   = +150 kPa
```

---

### Negative gauge pressure

When:

```text
Pabs < Patm
```

then:

```text
Pg < 0
```

Example:

```text
Patm = 100 kPa
Pabs = 70 kPa

Pg = 70 - 100
   = -30 kPa
```

This represents a **vacuum condition** relative to atmosphere.

### ⭐ Important

> **Gauge pressure can be positive, zero, or negative.**

But:

> **Absolute pressure cannot be negative.**

---

# 1.5 Vacuum Pressure

## Definition

> **Vacuum pressure is the pressure below atmospheric pressure.**

More precisely, it is the difference between atmospheric pressure and absolute pressure when the absolute pressure is below atmospheric pressure.

```math
P_{vac}=P_{atm}-P_{abs}
```

Since:

```math
P_g=P_{abs}-P_{atm}
```

we get:

```math
P_{vac}=-P_g
```

when gauge pressure is negative.

---

## 1.5.1 Pressure Relationship

```text
Perfect Vacuum
      │
      │
      ↓
Absolute Pressure
      │
      │ Vacuum pressure
      ↓
Atmospheric Pressure
      │
      │ Gauge pressure
      ↓
Higher Pressure
```

### Easy memory

```text
Above atmosphere → Positive gauge pressure

Below atmosphere → Negative gauge pressure
                  → Vacuum pressure
```

---

# 1.6 Pressure Head

Pressure can also be expressed as the height of an equivalent liquid column.

This is called:

> **Pressure head**

```math
h_p=\frac{P}{\rho g}
```

Since:

```math
\gamma=\rho g
```

we can write:

```math
h_p=\frac{P}{\gamma}
```

Unit:

```text
metre (m)
```

Dimension:

```text
[L]
```

### Important MCQ

**Unit of pressure head is:**

A. Pa
B. N/m²
C. m
D. kg/m³

**Answer: C** ✅

---

# 1.7 Hydrostatic Pressure

## 1.7.1 Meaning

Hydrostatic pressure is pressure in a **fluid at rest**.

Hydro:

> Fluid

Static:

> At rest

---

## 1.7.2 Hydrostatic Pressure Equation

For a fluid at rest:

```math
P=\rho gh
```

or:

```math
P=\gamma h
```

where:

* `P` = gauge pressure
* `ρ` = density
* `g` = gravitational acceleration
* `h` = depth
* `γ` = specific weight

---

# 1.7.3 Differential Hydrostatic Equation ⭐⭐⭐

The basic hydrostatic pressure relationship is:

```math
\frac{dP}{dh}=-\gamma
```

or:

```math
\frac{dP}{dh}=-\rho g
```

The negative sign appears because **pressure decreases as elevation `h` increases**.

If depth is measured downward instead of elevation upward, the relationship becomes:

```math
dP=\rho g\,dh
```

### Important MCQ

> `dP/dh = -γ` represents the **hydrostatic pressure equation**.

It is **not Pascal's law**.

---

# 1.7.4 Pascal's Law vs Hydrostatic Equation

These two are commonly confused.

## Pascal's Law

> Pressure applied to a confined fluid is transmitted undiminished in all directions and acts normally on the containing surfaces.

Example:

* Hydraulic jack
* Hydraulic press
* Hydraulic brake

---

## Hydrostatic equation

```math
\frac{dP}{dh}=-\gamma
```

It describes how pressure changes with **elevation/depth in a static fluid**.

### ⭐ MCQ Trap

```text
Pascal's law       → transmission of applied pressure

dP/dh = -γ         → hydrostatic pressure variation
```

---

# 1.7.5 Factors Affecting Hydrostatic Pressure

From:

```math
P=\rho gh
```

we can see:

### Density increases

```text
ρ ↑ → P ↑
```

### Depth increases

```text
h ↑ → P ↑
```

### Gravity increases

```text
g ↑ → P ↑
```

---

# 1.7.6 Pressure Increases with Depth

```text
Free surface
────────────────────────
          ↓
          │ h₁
          ↓
       Point A
────────────────────────
          ↓
          │ h₂
          ↓
       Point B
────────────────────────
```

If:

```text
h₂ > h₁
```

then:

```text
PB > PA
```

Therefore:

> **Pressure increases with depth.**

### [DIAGRAM SPACE]

```text
Draw water tank showing pressure increasing with depth.
```

---

# 1.7.7 Pressure at Same Depth

For the same continuous fluid at rest:

```text
A ●────────────● B
```

if A and B are at the same depth:

```math
P_A=P_B
```

### ⭐ Very important

> **Same fluid + same depth + static condition → same pressure.**

---

# 1.7.8 Container Shape Does Not Directly Affect Hydrostatic Pressure

For a static liquid:

```math
P=\rho gh
```

There is no container-shape term.

Therefore, at the same depth:

> Pressure is independent of the shape of the container.

### MCQ Trap

Different containers may contain different quantities of water but pressure at the same depth can be the same.

---

# 1.8 Pressure Measurement

Major instruments:

```text
Pressure Measurement
│
├── Barometer
├── Piezometer
├── Manometer
│   ├── Simple U-tube
│   ├── Differential U-tube
│   └── Inclined manometer
└── Bourdon pressure gauge
```

---

# 1.9 Piezometer

## Definition

A piezometer is a simple vertical tube connected to a pipe/vessel and open to atmosphere.

It measures:

> **Pressure head of a liquid.**

### [DIAGRAM SPACE]

```text
Draw a vertical piezometer connected to a pipe.
```

---

## Principle

It works using hydrostatic balance.

```math
P=\rho gh
```

Therefore:

```math
h=\frac{P}{\rho g}
```

---

## Applications

Used for:

* Liquid pressure measurement
* Pressure head measurement
* Low/moderate liquid pressures

---

## Limitations

A piezometer is generally not suitable for:

* Gas pressure
* Very high pressure
* Very low pressure requiring a very tall liquid column

### ⭐ MCQ

**Piezometer is primarily used for:**

> Liquid pressure/head

---

# 1.10 Manometer

## 1.10.1 Purpose of Manometer

A manometer is used to measure:

> **Pressure or pressure difference by balancing liquid columns under hydrostatic conditions.**

The basic principle is:

```math
P=\rho gh
```

A manometer converts pressure into a measurable **liquid-column height difference**.

---

## 1.10.2 Main Uses

Manometers can measure:

1. Gauge pressure
2. Vacuum pressure
3. Pressure difference
4. Small pressure differences, depending on design

---

# 1.10.3 Important Manometer Rule ⭐⭐⭐

When solving a manometer:

```text
Move DOWN through a liquid:
Pressure increases

Move UP through a liquid:
Pressure decreases
```

Mathematically:

```math
\Delta P=\rho g\Delta h
```

Therefore:

```text
DOWN → +ρgΔh

UP → −ρgΔh
```

---

# 1.10.4 Manometric Fluid

The liquid used inside a manometer is called:

> **Manometric fluid**

It should be selected according to the pressure range and the fluids being measured.

---

# 1.11 Simple U-Tube Manometer

A simple U-tube manometer generally measures pressure at one point relative to atmospheric pressure/reference pressure.

### [DIAGRAM SPACE]

```text
Draw:
Simple U-tube manometer connected to a pipe
with manometric liquid at the bottom.
```

---

## Working Principle

Pressure from the pipe causes the manometric liquid levels to change.

The difference in levels is related to pressure through hydrostatic balance.

For a simple arrangement, the basic idea is:

```math
P \sim \rho g h
```

The exact equation depends on the fluids and connection arrangement.

---

# 1.12 Differential U-Tube Manometer

## Definition

A differential manometer is used to determine:

> **Pressure difference between two points.**

For example:

```text
Point A ───────────── Point B
    │                   │
    │                   │
    └──── U-tube ───────┘
```

### [DIAGRAM SPACE]

```text
Draw:
Differential U-tube manometer connected between
two points A and B in a pipe.
```

---

## Purpose

If:

```math
P_A>P_B
```

the liquid levels move in a corresponding manner.

The manometer allows us to determine:

```math
\Delta P=P_A-P_B
```

---

## Simple vs Differential Manometer

| Simple U-tube                         | Differential U-tube  |
| ------------------------------------- | -------------------- |
| Pressure at one point                 | Pressure difference  |
| One point connected to pipe/reference | Two points connected |
| Often referenced to atmosphere        | Compares A and B     |

### ⭐ MCQ

**Which instrument is specifically used to measure pressure difference between two points?**

> Differential manometer.

---

# 1.13 Inclined Manometer ⭐⭐⭐

An inclined manometer is a manometer whose measuring tube is inclined at a small angle.

### [DIAGRAM SPACE]

```text
Draw:
Inclined manometer with angle θ and
small pressure difference.
```

---

## 1.13.1 Why is an Inclined Manometer Used?

It is particularly useful for:

> **Very small pressure differences.**

The vertical pressure head may be very small, but the movement along the inclined tube becomes much larger.

---

## 1.13.2 Relation Between Vertical Height and Length

If:

* `l` = length moved along inclined tube
* `h` = vertical height difference
* `θ` = angle of inclination

then:

```math
h=l\sin\theta
```

Therefore:

```math
l=\frac{h}{\sin\theta}
```

This is the key sensitivity relationship.

---

## 1.13.3 Why Low Inclination Gives High Sensitivity?

Suppose:

```text
θ ↓
```

Then:

```text
sin θ ↓
```

Therefore:

```math
l=\frac{h}{\sin\theta}
```

means:

```text
l ↑
```

for the same vertical pressure head.

Therefore:

> **Smaller inclination angle → larger movement → higher sensitivity.**

### ⭐ AMVI

```text
Low θ
  ↓
sin θ small
  ↓
l large
  ↓
High sensitivity
```

---

# 1.13.4 Applications

Inclined manometers are commonly used for:

* Very low pressure measurement
* Small pressure differences
* Gas pressure measurement
* Sensitive pressure measurements

---

# 1.13.5 Why Gas Pressure?

Gases often produce relatively small pressure differences in applications where an ordinary vertical manometer may show only a very small movement.

The inclined arrangement magnifies that movement.

Therefore:

> Inclined manometers are commonly used for **low-pressure gas measurements**.

---

# 1.13.6 Design Conditions for High Sensitivity

For high sensitivity:

### 1. Small inclination angle

```text
θ ↓ → sensitivity ↑
```

### 2. Small diameter of measuring tube

A small tube gives a clearer/larger displacement for small pressure differences.

### 3. Low-density manometric liquid

For a given pressure difference:

```math
\Delta P=\rho_m gh
```

Therefore:

```math
h=\frac{\Delta P}{\rho_m g}
```

If `ρm` decreases:

```text
h ↑
```

So a lower-density manometric liquid can provide greater displacement for a given small pressure difference.

---

## Important clarification

For an inclined manometer, the **tube diameter should be small**, but the reservoir arrangement is designed appropriately so that reservoir-level movement is negligible compared with the movement in the narrow tube.

---

# 1.13.7 Inclined Manometer – Quick Revision

```text
INCLINED MANOMETER
│
├── Very low pressure
├── Small pressure difference
├── Commonly used for gas
├── High sensitivity
├── Small inclination angle
├── Small measuring-tube diameter
└── Low-density manometric liquid
```

---

# 1.14 Manometric Fluids

A manometric fluid should have suitable properties for the pressure range and application.

Common examples include:

### High-density manometric fluids

* Mercury
* Carbon tetrachloride (historically used)
* Dense oils

### Low-density manometric fluids

* Water
* Light oils
* Organic liquids
* Alcohols

### Special low-pressure applications

* Water
* Alcohol
* Light oils
* Other low-density liquids chosen for compatibility and required sensitivity

---

# 1.14.1 Important Properties of a Good Manometric Fluid

A suitable manometric liquid generally should have:

1. Appropriate density
2. Low vapour pressure
3. Should not react with the measured fluid
4. Should not stick excessively to the tube
5. Should give a clear interface
6. Should have suitable viscosity
7. Should be chemically stable

---

# 1.15 Why is Mercury Used as a Manometric Fluid? ⭐⭐⭐

Mercury is widely associated with manometers and barometers.

Important reasons include:

### 1. High density

```text
ρHg ≈ 13,600 kg/m³
```

Therefore, for a given pressure:

```math
h=\frac{P}{\rho g}
```

Higher density → smaller column height.

This makes mercury practical for relatively high pressures.

---

### 2. Very low vapour pressure ⭐⭐⭐

This is an especially important reason.

Mercury has **very low vapour pressure**, so evaporation of the manometric liquid is small.

This is important because significant vapour pressure of the manometric liquid can introduce measurement errors.

### 3. Does not wet glass strongly

Mercury has a useful meniscus behavior in glass tubes and does not wet glass in the same way as water.

---

### 4. High density reduces column height

For the same pressure:

```text
Mercury → small column
Water → much larger column
```

### ⭐ MCQ

**An important property making mercury suitable for pressure measurement is:**

A. Very high vapour pressure
B. Very low density
C. Very low vapour pressure
D. Very high compressibility

**Answer: C** ✅

---

# 1.16 Conversion of Height of One Fluid into Another Fluid ⭐⭐⭐

This is a very important numerical concept.

Suppose a pressure is represented by:

```text
h₁
```

of fluid 1 and the same pressure is represented by:

```text
h₂
```

of fluid 2.

For the same pressure:

```math
P=\rho_1gh_1
```

and:

```math
P=\rho_2gh_2
```

Therefore:

```math
\rho_1gh_1=\rho_2gh_2
```

Cancel `g`:

```math
\rho_1h_1=\rho_2h_2
```

Therefore:

```math
h_2=\frac{\rho_1}{\rho_2}h_1
```

---

## 1.16.1 Using Specific Gravity

Since:

```math
SG=\frac{\rho}{\rho_{water}}
```

we can write:

```math
SG_1h_1=SG_2h_2
```

Therefore:

```math
h_2=\frac{SG_1}{SG_2}h_1
```

---

# 1.16.2 Example: Water to Mercury

Suppose:

```text
Water column = 13.6 m
```

Specific gravity:

```text
SGwater = 1
SGmercury = 13.6
```

Then:

```math
SG_w h_w=SG_{Hg}h_{Hg}
```

```math
1\times13.6=13.6\times h_{Hg}
```

Therefore:

```text
hHg = 1 m
```

So:

> **13.6 m water head = 1 m mercury head**

---

# 1.16.3 Very Important Conversion Rule

```text
Same pressure:

ρ₁h₁ = ρ₂h₂
```

or:

```text
SG₁h₁ = SG₂h₂
```

### Memory trick

> **Higher-density fluid requires a smaller column height for the same pressure.**

---

# 1.17 Bourdon Pressure Gauge

## Definition

A Bourdon pressure gauge is a mechanical pressure-measuring instrument that works using the **elastic deformation of a curved tube**.

---

## Construction

Main components:

```text
Bourdon tube
     ↓
Link
     ↓
Gear mechanism
     ↓
Pointer
     ↓
Dial
```

### [DIAGRAM SPACE]

```text
Draw:
Bourdon tube + link + gear + pointer + dial.
```

---

# 1.17.1 Working

Pressure enters the Bourdon tube.

The tube tends to deform/uncoil because of internal pressure.

This movement is transmitted through:

```text
Bourdon tube
      ↓
Link
      ↓
Gear
      ↓
Pointer
      ↓
Dial reading
```

Therefore:

> **Pressure → elastic deformation → mechanical movement → pressure indication**

---

## 1.17.2 Principle

```text
Elastic deformation
```

### ⭐ MCQ

Bourdon gauge works on:

A. Buoyancy
B. Surface tension
C. Elastic deformation
D. Capillary action

**Answer: C** ✅

---

# 1.18 Pressure Instruments – Complete Comparison

| Instrument              | Measures                       | Principle                    |
| ----------------------- | ------------------------------ | ---------------------------- |
| **Barometer**           | Atmospheric pressure           | Liquid column                |
| **Piezometer**          | Liquid pressure/head           | Hydrostatic column           |
| **Simple U-tube**       | Pressure at a point            | Hydrostatic balance          |
| **Differential U-tube** | Pressure difference            | Hydrostatic balance          |
| **Inclined manometer**  | Very small pressure difference | Enlarged liquid displacement |
| **Bourdon gauge**       | Pressure                       | Elastic deformation          |

---

# 1.19 Extremely Important AMVI MCQ Differences

## Gauge vs Absolute vs Vacuum

| Parameter         | Reference                         |
| ----------------- | --------------------------------- |
| Absolute pressure | Perfect vacuum                    |
| Gauge pressure    | Atmospheric pressure              |
| Vacuum pressure   | Amount below atmospheric pressure |

---

## Simple vs Differential Manometer

| Simple                        | Differential                 |
| ----------------------------- | ---------------------------- |
| One pressure/reference point  | Two pressure points          |
| Measures pressure             | Measures pressure difference |
| Usually atmospheric reference | Compares A and B             |

---

## Piezometer vs Manometer

| Piezometer                           | Manometer                                             |
| ------------------------------------ | ----------------------------------------------------- |
| Simple vertical tube                 | U-tube/other arrangement                              |
| Mainly liquid pressure               | Pressure/pressure difference                          |
| Limited pressure range               | Wider applications                                    |
| Cannot normally measure gas pressure | Can be used for gas pressure depending on arrangement |

---

# 1.20 High-Value MCQ Statements

Memorize these statements:
* Atmospheric pressure is measured by a **barometer**.
* Gauge pressure is measured with respect to atmospheric pressure.
* Gauge pressure can be **positive, zero, or negative**.
* Vacuum pressure represents pressure below atmospheric pressure.
* Absolute pressure is measured from perfect vacuum.
* Absolute pressure cannot be negative.
* `dP/dh = -γ` is the hydrostatic pressure equation.
* Pascal's law deals with transmission of pressure in a confined fluid.
* Piezometer is mainly used for liquid pressure/head.
* Differential manometer measures pressure difference between two points.
* Inclined manometer is useful for very small pressure differences.
* Smaller inclination angle gives higher sensitivity.
* Lower-density manometric fluid gives greater column displacement for the same pressure difference, other conditions being equal.
* Mercury has very low vapour pressure and high density.
* Higher-density manometric fluid requires a smaller column height for the same pressure.
* Bourdon gauge works on elastic deformation.


---

# 1.21 Final Formula Sheet

```math
P=\frac{F}{A}
```

```math
P_{abs}=P_{atm}+P_g
```

```math
P_g=P_{abs}-P_{atm}
```

```math
P_{vac}=P_{atm}-P_{abs}
```

```math
h_p=\frac{P}{\rho g}
```

```math
P=\rho gh
```

```math
\frac{dP}{dh}=-\rho g=-\gamma
```

```math
\Delta P=\rho g\Delta h
```

Inclined manometer:

```math
h=l\sin\theta
```

Therefore:

```math
l=\frac{h}{\sin\theta}
```

Fluid-column conversion:

```math
\rho_1h_1=\rho_2h_2
```

or:

```math
SG_1h_1=SG_2h_2
```

---

# 1.22 One-Minute AMVI Revision

```text
                    FLUID PRESSURE
                         │
       ┌─────────────────┼──────────────────┐
       ↓                 ↓                  ↓
    PRESSURE          PRESSURE TYPES     STATIC FLUID
       │                 │                  │
      F/A          Absolute / Gauge       τ = 0
                       / Vacuum             │
                                           Normal
                                           stress ≠ 0
       │
       ↓
 Hydrostatic
       │
      ρgh
       │
       ├── Depth ↑ → P ↑
       ├── Density ↑ → P ↑
       └── Same depth → same P
       
MEASUREMENT
│
├── Barometer → Atmospheric pressure
├── Piezometer → Liquid pressure head
├── Simple U-tube → Pressure
├── Differential U-tube → ΔP
├── Inclined → Very small ΔP
└── Bourdon → Elastic deformation

MANOMETER RULE
↓ DOWN → +ρgh
↑ UP   → −ρgh

INCLINED
θ ↓ → l ↑ → Sensitivity ↑

MERCURY
High density
+
Very low vapour pressure

COLUMN CONVERSION
ρ₁h₁ = ρ₂h₂
```

This expanded version now covers the **full 4.1–4.12 Fluid Pressure syllabus** plus the additional points you identified, including **simple/differential/inclined manometers, manometric fluids, mercury, column conversion, hydrostatic equation, Pascal-law distinction, and static-fluid stress concepts**.
