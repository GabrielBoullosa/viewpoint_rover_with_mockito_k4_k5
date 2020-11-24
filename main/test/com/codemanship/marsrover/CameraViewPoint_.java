package com.codemanship.marsrover;

import org.junit.Before;
import org.junit.Test;
import refactoring.Camera;
import refactoring.CameraViewPoint;
import refactoring.ImageProcessor;
import refactoring.ViewPoint;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CameraViewPoint_ {
    private CameraViewPoint initialViewPoint;
    @Before
    public void setUp() throws Exception {
        Camera camera = mock(Camera.class);
        ImageProcessor imageProcessor = mock(ImageProcessor.class);
        initialViewPoint = new CameraViewPoint(camera, imageProcessor);
    }

    @Test
    public void should_be_created_from_string() {
        ViewPoint viewPoint = initialViewPoint.turnLeft();
        assertThat(viewPoint).isNotNull();
        assertThat(viewPoint).isNotEqualTo(initialViewPoint);
        verify(initialViewPoint.camera()).turnLeft(90);
    }
}
