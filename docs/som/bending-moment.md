# Bending Stress — Complete AMVI-MPSC Notes

> **Combined notes from 01, 02 and 03 Bending Stress source PDFs, with additional AMVI-MPSC exam points added separately.**
>
> Source-derived concepts are retained from the uploaded handwritten notes. Additional explanations, examples and MCQ points are added to make the chapter more robust.

---

# 1. Pure Bending

A beam member is said to be under **pure bending** when it is subjected to **equal and opposite couples** such that the bending moment remains constant over the considered portion of the beam.

### Key points

- Pure bending produces a **constant bending moment**.
- Shear force in the pure-bending region is **zero**.
- The beam bends into a circular arc in the ideal simple-bending model.
- One side of the beam is under compression.
- The opposite side is under tension.
- The neutral axis lies between the tensile and compressive regions.

### Pure-bending region

For a simply supported beam carrying two equal loads symmetrically:

```text
      W                 W
      ↓                 ↓
A ────┬─────────────────┬──── D
      B                 C

      ←── Pure Bending ─→
```

For the arrangement shown in the source, the reactions are:

$$
R_A=W
$$

$$
R_D=W
$$

The bending moment between the two loads is constant.

If the distance from a reaction to the corresponding load is `L`:

$$
\boxed{M=WL}
$$

### AMVI point

> **Pure bending → constant bending moment → zero shear force.**

---

# 2. Bending of a Beam

Before bending, longitudinal fibres of a straight beam are approximately straight and parallel.

After bending:

- Fibres on one side become shorter → **compression**.
- Fibres on the other side become longer → **tension**.
- One layer does not change its length → **neutral fibre**.

The neutral fibre forms the basis for defining the **neutral axis** in the cross-section.

---

# 3. Neutral Axis

The **neutral axis (N.A.)** is the line in the cross-section where the longitudinal bending stress and longitudinal strain are zero in simple elastic bending.

At the neutral axis:

$$
\boxed{y=0}
$$

Therefore:

$$
\boxed{\varepsilon=0}
$$

and:

$$
\boxed{\sigma=0}
$$

### Important

For a homogeneous, symmetric, prismatic beam under simple bending about a centroidal principal axis, the neutral axis passes through the **centroid** of the cross-section.

> **AMVI:** Do not assume the neutral axis is always at the geometric center for every possible loading/cross-section. Its location depends on the bending situation and section properties.

---

# 4. Strain Distribution in Bending

Consider a beam bent into an arc of radius `R`.

Let:

- `R` = radius of curvature of neutral fibre
- `y` = distance of a fibre from neutral axis
- `θ` = angle subtended by the neutral fibre

Length of neutral fibre:

$$
L=R\theta
$$

For a fibre at distance `y` on the compressed side:

$$
L_y=(R-y)\theta
$$

Hence:

$$
\varepsilon
=
\frac{L_y-L}{L}
$$

$$
\varepsilon
=
\frac{(R-y)\theta-R\theta}{R\theta}
$$

Therefore:

$$
\boxed{\varepsilon=-\frac{y}{R}}
$$

The sign depends on whether the fibre is on the tensile or compressive side.

In magnitude:

$$
\boxed{|\varepsilon|=\frac{|y|}{R}}
$$

### Main conclusion

$$
\boxed{\varepsilon\propto y}
$$

Therefore:

> **Longitudinal strain varies linearly with distance from the neutral axis.**

---

# 5. Stress Distribution in Bending

Within the elastic range, Hooke's law applies:

$$
\sigma=E\varepsilon
$$

Using:

$$
\varepsilon=-\frac{y}{R}
$$

we get:

$$
\boxed{\sigma=-\frac{Ey}{R}}
$$

In magnitude:

$$
\boxed{|\sigma|=\frac{E|y|}{R}}
$$

Therefore:

- Stress is zero at the neutral axis.
- Stress varies linearly from the neutral axis.
- Maximum stress occurs at the extreme fibre.
- Tensile and compressive stresses occur on opposite sides.

### Stress distribution

```text
        Compression
             /|
            / |
           /  |
----------/---|---------- Neutral Axis
         /    |
        /     |
       /      |
      /       |
         Tension

Stress varies linearly with distance from N.A.
```

---

# 6. Maximum Bending Stress

Since:

$$
\sigma=\frac{My}{I}
$$

maximum stress occurs at maximum `y`.

Therefore:

$$
\boxed{\sigma_{\max}=\frac{My_{\max}}{I}}
$$

Define section modulus:

$$
\boxed{Z=\frac{I}{y_{\max}}}
$$

Therefore:

$$
\boxed{\sigma_{\max}=\frac{M}{Z}}
$$

### AMVI point

> **Maximum bending stress occurs at the extreme fibre, not at the neutral axis.**

---

# 7. Euler-Bernoulli / Simple Bending Equation

The fundamental bending equation is:

$$
\boxed{
\frac{\sigma}{y}
=
\frac{M}{I}
=
\frac{E}{R}
}
$$

Where:

| Symbol | Meaning | Typical unit |
|---|---|---|
| `σ` | Bending stress | MPa or N/mm² |
| `y` | Distance from neutral axis | mm or m |
| `M` | Bending moment | N·mm, N·m, kN·m |
| `I` | Second moment of area | mm⁴ or m⁴ |
| `E` | Young's modulus | MPa, GPa |
| `R` | Radius of curvature | mm or m |

### Rearranged forms

$$
\boxed{\sigma=\frac{My}{I}}
$$

$$
\boxed{M=\frac{\sigma I}{y}}
$$

$$
\boxed{\frac{E}{R}=\frac{M}{I}}
$$

---

# 8. Derivation of Moment of Resistance

Consider a small cross-sectional area `dA` at distance `y`.

Stress:

$$
\sigma=\frac{Ey}{R}
$$

Small resisting force:

$$
dF=\sigma dA
$$

Therefore:

$$
dF=\frac{Ey}{R}dA
$$

Moment of this elemental force about the neutral axis:

$$
dM_R=dF\times y
$$

Thus:

$$
dM_R=\frac{E}{R}y^2dA
$$

Integrating over the entire cross-section:

$$
M_R=\frac{E}{R}\int y^2dA
$$

By definition:

$$
\boxed{I=\int y^2dA}
$$

Therefore:

$$
\boxed{M_R=\frac{EI}{R}}
$$

and:

$$
\boxed{\frac{M_R}{I}=\frac{E}{R}}
$$

Combining with the stress relation:

$$
\boxed{
\frac{\sigma}{y}
=
\frac{M}{I}
=
\frac{E}{R}
}
$$

---

# 9. Moment of Resistance

The internal tensile and compressive stresses form an internal couple.

This internal couple is called the **moment of resistance**.

At the limiting permissible condition:

$$
\boxed{M_R=\sigma_{\text{permissible}}Z}
$$

For safe design:

$$
\boxed{M<M_R}
$$

where:

- `M` = applied bending moment
- `M_R` = resisting moment based on permissible stress

---

# 10. Section Modulus

Section modulus is defined as:

$$
\boxed{Z=\frac{I}{y_{\max}}}
$$

It is a **geometrical property of a cross-section**.

From:

$$
\sigma_{\max}=\frac{M}{Z}
$$

for the same bending moment:

$$
Z\uparrow\Rightarrow\sigma_{\max}\downarrow
$$

For the same permissible stress:

$$
Z\uparrow\Rightarrow M_R\uparrow
$$

### Important distinction

- `I` measures resistance related to distribution of area about an axis.
- `Z` directly relates bending moment to extreme-fibre bending stress.
- `E` is a material property.
- `EI` is flexural rigidity.

---

# 11. Common Section Modulus Formulas

## 11.1 Solid Circular Section

Diameter = `d`

$$
I=\frac{\pi d^4}{64}
$$

$$
y_{\max}=\frac{d}{2}
$$

Therefore:

$$
\boxed{Z=\frac{\pi d^3}{32}}
$$

---

## 11.2 Hollow Circular Section

Outer diameter = `D`

Inner diameter = `d`

$$
I=\frac{\pi}{64}(D^4-d^4)
$$

$$
y_{\max}=\frac{D}{2}
$$

Therefore:

$$
\boxed{
Z=\frac{\pi(D^4-d^4)}{32D}
}
$$

Equivalent form:

$$
\boxed{
Z=
\frac{\pi D^3}{32}
\left[
1-\left(\frac{d}{D}\right)^4
\right]
}
$$

---

## 11.3 Rectangular Section

Width = `b`

Depth = `d`

$$
I=\frac{bd^3}{12}
$$

$$
y_{\max}=\frac{d}{2}
$$

Therefore:

$$
\boxed{Z=\frac{bd^2}{6}}
$$

### Important

$$
Z\propto d^2
$$

So increasing depth is more effective than increasing width for the same orientation.

---

## 11.4 Triangular Section

Base = `b`

Height = `h`

For the extreme fibre arrangement shown in the source:

$$
I=\frac{bh^3}{36}
$$

Distance from neutral axis to the apex:

$$
y_{\max}=\frac{2h}{3}
$$

Therefore:

$$
\boxed{Z=\frac{bh^2}{24}}
$$

---

## 11.5 Diamond / Rhombus Section

For the diamond-shaped geometry shown in the source, with side `a`, the source calculation gives:

$$
\boxed{
Z=\frac{a^3}{6\sqrt{2}}
}
$$

> **Source-specific:** Use this result with the same geometry/orientation shown in the source diagram.

---

# 12. Section Modulus Quick Table

| Section | Section Modulus |
|---|---|
| Solid circle, diameter `d` | `Z = πd³/32` |
| Hollow circle | `Z = π(D⁴-d⁴)/(32D)` |
| Rectangle `b × d` | `Z = bd²/6` |
| Triangle `b × h` | `Z = bh²/24` |
| Diamond/rhombus shown in source | `Z = a³/(6√2)` |

---

# 13. Strength Criterion

Strength criterion checks whether the developed stress remains within the allowable value.

Safe condition:

$$
\boxed{
\sigma_{\text{developed}}
<
\sigma_{\text{permissible}}
}
$$

For bending:

$$
\frac{M}{Z}<\sigma_{\text{permissible}}
$$

The permissible stress is commonly related to failure/yield stress through a factor of safety:

$$
\boxed{
\sigma_{\text{permissible}}
=
\frac{\sigma_{\text{reference}}}{\text{Factor of Safety}}
}
$$

The exact reference stress depends on the design standard/material/design method.

### AMVI concept

> **Strength → stress → failure prevention.**

---

# 14. Rigidity Criterion

Rigidity criterion controls excessive deformation.

Safe condition:

$$
\boxed{
\text{Maximum deformation}
<
\text{Permissible deformation}
}
$$

For a simple axial member:

$$
\delta=\frac{PL}{AE}
$$

Therefore:

$$
\boxed{
\frac{PL}{AE}<\delta_{\text{permissible}}
}
$$

### Strength vs Rigidity

| Strength Criterion | Rigidity Criterion |
|---|---|
| Concerned with stress | Concerned with deformation |
| Prevents excessive stress/failure | Limits excessive deformation |
| Uses permissible stress | Uses permissible deformation |
| Bending check: `M/Z < σ_per` | Deflection must remain within limit |

---

# 15. Flexural Rigidity

From:

$$
\frac{M}{I}=\frac{E}{R}
$$

we get:

$$
M=\frac{EI}{R}
$$

Therefore:

$$
\boxed{EI=\text{Flexural Rigidity}}
$$

where:

- `E` = material stiffness
- `I` = cross-sectional geometric property

### Important

For the same material:

$$
E=\text{constant}
$$

so increasing `I` increases flexural rigidity.

For a given bending moment:

$$
\frac{1}{R}=\frac{M}{EI}
$$

Therefore, larger `EI` gives smaller curvature.

---

# 16. Curvature of a Beam

From:

$$
\frac{M}{I}=\frac{E}{R}
$$

we obtain:

$$
\boxed{\frac{1}{R}=\frac{M}{EI}}
$$

This quantity `1/R` is the **curvature**.

Therefore:

$$
M\uparrow\Rightarrow\frac{1}{R}\uparrow
$$

for constant `E` and `I`.

And:

$$
EI\uparrow\Rightarrow\frac{1}{R}\downarrow
$$

for constant `M`.

### AMVI memory

> **Moment causes curvature; flexural rigidity resists curvature.**

---

# 17. Thin-Walled Belt / Ring Section

The source includes a thin-walled belt/ring-type section and uses the bending-stress relation.

For the specific geometry shown in the source, where thickness `t` is very small, the source obtains:

$$
\boxed{
\sigma_{\max}=\frac{Et}{D+t}
}
$$

> **Source-specific formula:** This result should be used with the same geometry and assumptions shown in the supplied diagram. Do not apply it to every thin-walled section automatically.

---

# 18. Comparison of Section Orientations

The source compares a square in two different orientations.

The governing relationship is:

$$
\boxed{\sigma=\frac{M}{Z}}
$$

For the same bending moment:

$$
\boxed{
\frac{\sigma_1}{\sigma_2}
=
\frac{Z_2}{Z_1}
}
$$

Thus:

> The orientation having the larger section modulus develops lower bending stress for the same bending moment.

The source's calculation gives:

$$
\boxed{\frac{Z_I}{Z_{II}}=\sqrt{2}}
$$

Therefore:

$$
\boxed{
\frac{\sigma_I}{\sigma_{II}}
=
\frac{1}{\sqrt{2}}
}
$$

for the orientation labels used in the source calculation.

> **Exam caution:** Always identify which orientation is called I and II before using the ratio.

---

# 19. Beam of Uniform Strength

A beam of uniform strength is designed so that the bending stress remains the same at different sections along its length.

Since:

$$
\sigma=\frac{M}{Z}
$$

for constant bending stress:

$$
\boxed{\frac{M}{Z}=\text{constant}}
$$

Therefore:

$$
\boxed{Z\propto M}
$$

when permissible stress is constant.

### Meaning

Where bending moment is high:

- Section modulus should be high.

Where bending moment is low:

- Section modulus can be lower.

This principle is used to reduce unnecessary material while maintaining the required stress level.

---

# 20. Why I-Sections Are Efficient in Bending

The source illustrates an I-shaped section and notes that material is placed toward the extreme fibres.

The reason comes directly from:

$$
\sigma=\frac{My}{I}
$$

Bending stress increases with distance `y` from the neutral axis.

Therefore, material placed far from the neutral axis contributes strongly to the second moment of area.

### Concept

```text
Extreme fibre
      ↑
  High bending stress
      ↑
Material placed here is structurally effective
      ↑
Neutral axis
      ↓
Low/zero bending stress
      ↓
Extreme fibre
```

This is one reason I-sections are commonly used as efficient bending members.

---

# 21. Assumptions of Simple Bending Theory

The source lists the following assumptions:

1. Material is homogeneous and isotropic.
2. Beam/bar is prismatic.
3. Material obeys Hooke's law.
4. Member is under pure bending.
5. Young's modulus is constant in tension and compression.
6. Bending couple acts about a centroidal principal axis of the cross-section.
7. Plane sections remain plane after bending.

### Meaning of important assumptions

#### Homogeneous

Material properties are the same throughout the member.

#### Isotropic

Material properties are the same in different directions.

#### Prismatic

Cross-section remains constant along the length.

#### Hooke's law

Stress is proportional to strain within the elastic range:

$$
\sigma=E\varepsilon
$$

#### Plane sections remain plane

A plane cross-section before bending remains plane after bending in the simple bending model.

> **Very important AMVI point:** Plane sections remain plane after bending.

---

# 22. Important Difference: Stress, Strain, I, Z, E and EI

| Quantity | Meaning | Type |
|---|---|---|
| `σ` | Bending stress | Material response |
| `ε` | Strain | Deformation measure |
| `I` | Second moment of area | Geometrical property |
| `Z` | Section modulus | Geometrical property |
| `E` | Young's modulus | Material property |
| `EI` | Flexural rigidity | Combined material + geometry |

### Memory

```text
E → Material stiffness
I → Section geometry
EI → Flexural rigidity
Z → Bending stress capacity indicator
```

---

# 23. Important Numerical Examples

## Example 1 — Bending Stress

A beam has:

- `M = 10 kN·m`
- `I = 20 × 10^6 mm⁴`
- `y = 50 mm`

Convert:

$$
M=10\times10^6\text{ N·mm}
$$

Using:

$$
\sigma=\frac{My}{I}
$$

$$
\sigma=
\frac{10\times10^6\times50}
{20\times10^6}
$$

$$
\boxed{\sigma=25\text{ MPa}}
$$

---

## Example 2 — Section Modulus

A rectangular section has:

- `b = 100 mm`
- `d = 200 mm`

$$
Z=\frac{bd^2}{6}
$$

$$
Z=
\frac{100(200)^2}{6}
$$

$$
\boxed{Z=666666.7\text{ mm}^3}
$$

---

## Example 3 — Maximum Bending Stress

For:

- `M = 20 kN·m`
- `Z = 500000 mm³`

Convert:

$$
M=20\times10^6\text{ N·mm}
$$

Then:

$$
\sigma_{\max}=\frac{M}{Z}
$$

$$
\sigma_{\max}
=
\frac{20\times10^6}{500000}
$$

$$
\boxed{\sigma_{\max}=40\text{ MPa}}
$$

---

## Example 4 — Stress at Another Fibre

Maximum stress is `60 MPa` at `50 mm` from the neutral axis.

Find stress at `30 mm`.

Because:

$$
\sigma\propto y
$$

$$
\frac{\sigma_{30}}{60}
=
\frac{30}{50}
$$

Therefore:

$$
\boxed{\sigma_{30}=36\text{ MPa}}
$$

---

## Example 5 — Solid Circular Section

A solid circular beam has diameter `100 mm`.

$$
Z=\frac{\pi d^3}{32}
$$

$$
Z=\frac{\pi(100)^3}{32}
$$

$$
\boxed{Z\approx981747.7\text{ mm}^3}
$$

---

## Example 6 — Flexural Rigidity

Suppose:

- `E = 200 GPa`
- `I = 50 × 10^6 mm⁴`

Convert:

$$
E=200000\text{ N/mm}^2
$$

Therefore:

$$
EI=200000(50\times10^6)
$$

$$
\boxed{EI=10^{13}\text{ N·mm}^2}
$$

---

# 24. High-Yield AMVI-MPSC One-Liners

1. Pure bending produces constant bending moment.
2. Shear force is zero in a pure-bending region.
3. Neutral axis has zero bending stress.
4. Neutral axis has zero longitudinal strain.
5. Bending strain varies linearly with distance from N.A.
6. Bending stress varies linearly with distance from N.A.
7. Maximum bending stress occurs at the extreme fibre.
8. Bending stress is tensile on one side and compressive on the other.
9. Basic bending equation is `σ/y = M/I = E/R`.
10. Section modulus is `Z = I/y_max`.
11. Maximum bending stress is `M/Z`.
12. Section modulus is a geometrical property.
13. Moment of resistance is the internal resisting couple.
14. `M_R = σ_per Z`.
15. Safe strength design requires developed stress to be below permissible stress.
16. Rigidity criterion controls deformation.
17. Flexural rigidity is `EI`.
18. Curvature is `1/R`.
19. `1/R = M/EI`.
20. Increasing `EI` reduces curvature for the same moment.
21. For a rectangle, `Z = bd²/6`.
22. For a solid circle, `Z = πd³/32`.
23. For a hollow circle, `Z = π(D⁴-d⁴)/(32D)`.
24. For a triangle in the source orientation, `Z = bh²/24`.
25. For fixed `M`, increasing `Z` decreases bending stress.
26. For fixed permissible stress, increasing `Z` increases moment resistance.
27. Beam of uniform strength satisfies `M/Z = constant`.
28. For uniform strength and constant permissible stress, `Z ∝ M`.
29. Material near the extreme fibres is highly effective in increasing bending resistance.
30. Plane sections remain plane is a fundamental simple-bending assumption.
31. Simple bending theory assumes homogeneous and isotropic material.
32. Simple bending theory assumes a prismatic member.
33. Hooke's law is assumed valid.
34. `E` is a material property.
35. `I` is a geometrical property.
36. `Z` is a geometrical property.
37. `EI` combines material stiffness and geometry.
38. Tensile and compressive stresses are equal in magnitude only for symmetric material/geometry and symmetric pure bending conditions; do not assume this for every unsymmetrical section.
39. Sign of bending stress depends on the adopted sign convention.
40. Stress magnitude is what is normally required in basic numerical questions unless tensile/compressive nature is asked.

---

# 25. Common AMVI Traps

### Trap 1

**Question:** Where is bending stress maximum?

❌ Neutral axis

✅ Extreme fibre

---

### Trap 2

**Question:** Where is bending stress zero?

✅ Neutral axis

---

### Trap 3

**Question:** What is section modulus?

❌ `I × y`

✅

$$
Z=\frac{I}{y_{\max}}
$$

---

### Trap 4

**Question:** What is flexural rigidity?

❌ `E/Z`

❌ `I/E`

✅

$$
EI
$$

---

### Trap 5

**Question:** What happens when section modulus increases?

For fixed `M`:

$$
\sigma_{\max}=\frac{M}{Z}
$$

Therefore:

$$
Z\uparrow\Rightarrow\sigma_{\max}\downarrow
$$

---

### Trap 6

**Question:** What happens when `EI` increases?

For fixed `M`:

$$
\frac{1}{R}=\frac{M}{EI}
$$

Therefore curvature decreases.

---

### Trap 7

**Question:** Pure bending means?

✅ Constant bending moment.

Not simply "any bending of a beam."

---

# 26. AMVI-MPSC MCQs

### MCQ 1

In pure bending, the bending moment is:

A. Zero  
B. Constant  
C. Increasing linearly  
D. Increasing parabolically

**Answer: B**

---

### MCQ 2

In a pure-bending region, shear force is:

A. Maximum  
B. Minimum but non-zero  
C. Zero  
D. Infinite

**Answer: C**

---

### MCQ 3

Bending stress is maximum at:

A. Neutral axis  
B. Centroid only  
C. Extreme fibre  
D. Mid-depth always

**Answer: C**

---

### MCQ 4

Bending stress at the neutral axis is:

A. Maximum  
B. Minimum but non-zero  
C. Zero  
D. Equal to UTS

**Answer: C**

---

### MCQ 5

The bending equation is:

A. `σ = E/I`  
B. `σ/y = M/I = E/R`  
C. `M = EI/R²`  
D. `σ = M I/y`

**Answer: B**

---

### MCQ 6

Section modulus is:

A. `I y_max`  
B. `I/y_max`  
C. `y_max/I`  
D. `M/I`

**Answer: B**

---

### MCQ 7

Maximum bending stress is:

A. `MZ`  
B. `M/I`  
C. `M/Z`  
D. `Z/M`

**Answer: C**

---

### MCQ 8

Flexural rigidity is:

A. `E/I`  
B. `E + I`  
C. `EI`  
D. `E/Z`

**Answer: C**

---

### MCQ 9

For the same bending moment, if section modulus doubles, maximum bending stress becomes:

A. Double  
B. Half  
C. Four times  
D. Unchanged

**Answer: B**

---

### MCQ 10

For a rectangular section, section modulus is:

A. `bd/6`  
B. `bd²/6`  
C. `b²d/6`  
D. `bd³/12`

**Answer: B**

---

### MCQ 11

For a solid circular section of diameter `d`, section modulus is:

A. `πd²/32`  
B. `πd³/32`  
C. `πd⁴/64`  
D. `πd³/64`

**Answer: B**

---

### MCQ 12

For a beam of uniform strength:

A. `MZ = constant`  
B. `M/Z = constant`  
C. `M/I = 0`  
D. `Z/M = 0`

**Answer: B**

---

### MCQ 13

Curvature of a beam in elastic bending is:

A. `EI/M`  
B. `M/EI`  
C. `M/E`  
D. `I/M`

**Answer: B**

---

### MCQ 14

The unit of section modulus is:

A. `mm²`  
B. `mm³`  
C. `mm⁴`  
D. `N/mm²`

**Answer: B**

---

### MCQ 15

The unit of moment of inertia of area is:

A. `mm`  
B. `mm²`  
C. `mm³`  
D. `mm⁴`

**Answer: D**

---

# 27. Formula Sheet — Last-Minute Revision

## Fundamental bending equation

$$
\boxed{
\frac{\sigma}{y}
=
\frac{M}{I}
=
\frac{E}{R}
}
$$

## Bending stress

$$
\boxed{\sigma=\frac{My}{I}}
$$

## Maximum bending stress

$$
\boxed{\sigma_{\max}=\frac{M}{Z}}
$$

## Section modulus

$$
\boxed{Z=\frac{I}{y_{\max}}}
$$

## Moment of resistance

$$
\boxed{M_R=\sigma_{\text{permissible}}Z}
$$

## Curvature

$$
\boxed{\frac{1}{R}=\frac{M}{EI}}
$$

## Flexural rigidity

$$
\boxed{EI}
$$

## Moment of resistance from curvature

$$
\boxed{M_R=\frac{EI}{R}}
$$

## Second moment of area

$$
\boxed{I=\int y^2dA}
$$

## Solid circle

$$
\boxed{Z=\frac{\pi d^3}{32}}
$$

## Hollow circle

$$
\boxed{
Z=\frac{\pi(D^4-d^4)}{32D}
}
$$

## Rectangle

$$
\boxed{Z=\frac{bd^2}{6}}
$$

## Triangle — source orientation

$$
\boxed{Z=\frac{bh^2}{24}}
$$

## Uniform strength

$$
\boxed{\frac{M}{Z}=\text{constant}}
$$

---

# 28. Final Memory Map

```text
                         BENDING STRESS
                              │
              ┌───────────────┴────────────────┐
              │                                │
         PURE BENDING                     SIMPLE BENDING
              │                                │
       M = constant                         σ/y
              │                                │
       V = 0 in region                       M/I
                                               │
                                               E/R
                                               │
                           ┌───────────────────┼──────────────────┐
                           │                   │                  │
                         STRESS              STRAIN            CURVATURE
                           │                   │                  │
                        σ = My/I             ε = y/R            1/R=M/EI
                           │                   │                  │
                           ↓                   ↓                  ↓
                    Max at extreme       Zero at N.A.      EI resists
                       fibre                                  curvature
                           │
                           ↓
                    SECTION MODULUS
                           │
                       Z = I/ymax
                           │
                       σmax = M/Z
                           │
             ┌─────────────┴─────────────┐
             │                           │
        Strength                     Rigidity
             │                           │
      σ < σpermissible          δ < δpermissible
             │
      MR = σper Z
```

---

# 29. Ultra-Short AMVI Revision

> **Pure bending:** `M = constant`, `V = 0`

> **Neutral axis:** `σ = 0`, `ε = 0`

> **Extreme fibre:** maximum bending stress

> **Bending equation:** `σ/y = M/I = E/R`

> **Section modulus:** `Z = I/y_max`

> **Maximum stress:** `σ_max = M/Z`

> **Moment resistance:** `M_R = σ_per Z`

> **Flexural rigidity:** `EI`

> **Curvature:** `1/R = M/EI`

> **Uniform strength:** `M/Z = constant`

> **Most important assumption:** plane sections remain plane after bending.
