package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Rover;
import refactoring.SimpleViewPoint;

import static org.assertj.core.api.Assertions.assertThat;
import static refactoring.Rover.Order.*;
import static refactoring.SimpleViewPoint.Heading.*;

public class Rover__ {

    @Test
    public void could_turn_left() {
        Rover rover = new Rover(new SimpleViewPoint(North, new SimpleViewPoint.Position(3, 3)));
        rover.go(Left);
        assertThat(((SimpleViewPoint)rover.viewPoint()).heading()).isEqualTo(West);
        assertThat(((SimpleViewPoint)rover.viewPoint()).position()).isEqualTo(new SimpleViewPoint.Position(3,3));
    }

    @Test
    public void could_turn_right() {
        Rover rover = new Rover(new SimpleViewPoint(East, new SimpleViewPoint.Position(5, 1)));
        rover.go(Right);
        assertThat(((SimpleViewPoint)rover.viewPoint()).heading()).isEqualTo(South);
        assertThat(((SimpleViewPoint)rover.viewPoint()).position()).isEqualTo(new SimpleViewPoint.Position(5,1));
    }

    @Test
    public void could_go_forward() {
        Rover rover = new Rover(new SimpleViewPoint(South, new SimpleViewPoint.Position(-1, 1)));
        rover.go(Forward);
        assertThat(((SimpleViewPoint)rover.viewPoint()).heading()).isEqualTo(South);
        assertThat(((SimpleViewPoint)rover.viewPoint()).position()).isEqualTo(new SimpleViewPoint.Position(-1,0));
    }

    @Test
    public void could_go_backward() {
        Rover rover = new Rover(new SimpleViewPoint(West, new SimpleViewPoint.Position(-4, 4)));
        rover.go(Backward);
        assertThat(((SimpleViewPoint)rover.viewPoint()).heading()).isEqualTo(West);
        assertThat(((SimpleViewPoint)rover.viewPoint()).position()).isEqualTo(new SimpleViewPoint.Position(-3,4));
    }

    @Test
    public void could_execute_many_orders() {
        Rover rover = new Rover(new SimpleViewPoint(West, new SimpleViewPoint.Position(3, 1)));
        rover.go(Backward, Left, Forward, Right, Forward);
        assertThat(((SimpleViewPoint)rover.viewPoint()).heading()).isEqualTo(West);
        assertThat(((SimpleViewPoint)rover.viewPoint()).position()).isEqualTo(new SimpleViewPoint.Position(3,0));
    }

    @Test
    public void could_execute_legacy_instructions() {
        Rover rover = new Rover(new SimpleViewPoint(West, new SimpleViewPoint.Position(3, 1)));
        rover.go("BLFRF");
        assertThat(((SimpleViewPoint)rover.viewPoint()).heading()).isEqualTo(West);
        assertThat(((SimpleViewPoint)rover.viewPoint()).position()).isEqualTo(new SimpleViewPoint.Position(3,0));
    }


    @Test
    public void could_ignore_legacy_instructions() {
        Rover rover = new Rover(new SimpleViewPoint(West, new SimpleViewPoint.Position(3, 1)));
        rover.go("BL*FRF");
        assertThat(((SimpleViewPoint)rover.viewPoint()).heading()).isEqualTo(West);
        assertThat(((SimpleViewPoint)rover.viewPoint()).position()).isEqualTo(new SimpleViewPoint.Position(3,0));
    }
}
