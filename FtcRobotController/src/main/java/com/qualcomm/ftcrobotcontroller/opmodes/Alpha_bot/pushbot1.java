/* Copyright (c) 2014, 2015 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.qualcomm.ftcrobotcontroller.opmodes.Alpha_bot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;



import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TeleOp Mode
 * <p>
 *Enables control of the robot via the gamepad
 */
public class pushbot1 extends OpMode {

    private String startDate;
    private ElapsedTime runtime = new ElapsedTime();

    DcMotor mright;
    DcMotor mleft;
    Servo servo;

    int eleft;
    int eright;
    public void sleep(int ms)
    {
        try { Thread.sleep(ms); }
// Have to catch an interrupt exception that hopefully never happens.
        catch (InterruptedException ex) {Thread.currentThread().interrupt(); }
    }
    @Override

    public void init() {
    }
    //
    /*
       * Code to run when the op mode is first enabled goes here
       * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
       */
    @Override
    public void init_loop() {
        startDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        runtime.reset();

        //get references from hardware map
        mright = hardwareMap.dcMotor.get("arch");
        mleft = hardwareMap.dcMotor.get("mleft");

    }

    /*
     * This method will be called repeatedly in a loop
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
    @Override
    public void loop() {
        //reference telemetery
        telemetry.addData("1 Start", "NullOp started at " + startDate);
        telemetry.addData("2 Status", "running for " + runtime.toString());

        //get gamepad position
        float left = gamepad1.right_stick_y;
        float right = -gamepad1.left_stick_y;
        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);
        mright.setPower(right*right*right);
        mleft.setPower(left/2);
        if(gamepad1.a)
        {

            servo.setPosition(.10);
            sleep(1000);
            servo.setPosition(.20);
            sleep(1000);
            servo.setPosition(.30);
            sleep(1000);
            servo.setPosition(.40);
            sleep(1000);
            servo.setPosition(.50);
            sleep(1000);
            servo.setPosition(.60);
            sleep(1000);
            servo.setPosition(.70);
            sleep(1000);
            servo.setPosition(.80);
            sleep(1000);
            servo.setPosition(.90);
            sleep(1000);
            servo.setPosition(0);
        }

    }
}
