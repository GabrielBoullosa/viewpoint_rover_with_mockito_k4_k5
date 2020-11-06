package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.SimpleViewPoint;
import refactoring.ViewPoint;

import static org.assertj.core.api.Assertions.assertThat;
import static refactoring.ViewPoint.Heading.North;

public class ViewPoint_ {
    @Test
    public void could_be_initialized_with_legacy_constructor() {
        assertThat(new SimpleViewPoint("N", 5, 5).heading()).isEqualTo(North);
        assertThat(new SimpleViewPoint("North", 5, 5).heading()).isEqualTo(North);
        assertThat(new SimpleViewPoint("North", 5, 5).position()).isEqualTo(new ViewPoint.Position(5,5));
    }

    @Test
    public void could_be_initialized_using_new_constructors() {
        assertThat(new SimpleViewPoint(North, new ViewPoint.Position(4,4)).position()).isEqualTo(new ViewPoint.Position(4,4));
        assertThat(new SimpleViewPoint(North, 4, 4).position()).isEqualTo(new ViewPoint.Position(4,4));
    }
}
