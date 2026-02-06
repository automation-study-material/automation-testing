## XML Sample file.

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="EcommerceSuite" parallel="methods" thread-count="3">

    <!-- ================================================= -->
    <!-- TEST BLOCK 1 → Smoke Only -->
    <!-- ================================================= -->

    <test name="SmokeTests">

        <!-- Group include/exclude -->
        <groups>
            <run>
                <include name="smoke"/>
                <exclude name="slow"/>
            </run>
        </groups>

        <classes>

            <!-- Include entire class -->
            <class name="tests.LoginTest"/>

            <!-- Include class but exclude one method -->
            <class name="tests.PaymentTest">
                <methods>
                    <exclude name="paymentFailureTest"/>
                </methods>
            </class>

        </classes>

    </test>


    <!-- ================================================= -->
    <!-- TEST BLOCK 2 → Regression -->
    <!-- ================================================= -->

    <test name="RegressionTests">

        <groups>
            <run>
                <include name="regression"/>
            </run>
        </groups>

        <classes>

            <!-- Include only specific methods -->
            <class name="tests.OrderTest">
                <methods>
                    <include name="placeOrder"/>
                    <include name="cancelOrder"/>
                </methods>
            </class>

            <!-- Completely exclude class -->
            <class name="tests.LegacyTest">
                <methods>
                    <exclude name=".*"/>
                </methods>
            </class>

        </classes>

    </test>


    <!-- ================================================= -->
    <!-- TEST BLOCK 3 → Full Suite -->
    <!-- ================================================= -->

    <test name="FullSuite">

        <classes>

            <!-- Run everything -->
            <class name="tests.*"/>

        </classes>

    </test>

</suite>
```
