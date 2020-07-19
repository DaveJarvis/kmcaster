/*
 * Copyright 2020 White Magic Software, Ltd.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  o Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.whitemagicsoftware.kmcaster;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Responsible for drawing an image based on a state; the state can be
 * changed at any time.
 *
 * @param <S> The type of state associated with an image.
 */
public class HardwareComponent<S, I extends Image> extends JComponent {
  private final static Insets INSET_PROJECTED =
      new Insets( 3, 7, 6, 7 );

  private final Map<S, I> mStateImages = new HashMap<>();

  /**
   * Active state.
   */
  private S mState;

  /**
   * Constructs a new {@link HardwareComponent} without an initial state. The
   * initial state must be set by calling {@link #setState(Object)} before
   * drawing the image.
   */
  public HardwareComponent() {
  }

  /**
   * Associates a new (or existing) state with the given image. If the
   * state already exists for the image, the image is updated for that
   * state. After calling this method, the active state changes to the
   * given state as a convenience.
   *
   * @param state The state to associate with an image.
   * @param image The image to paint when the given state is selected.
   */
  public void put( final S state, final I image ) {
    getStateImages().put( state, image );
    setState( state );
  }

  @Override
  public Dimension getPreferredSize() {
    // Race-condition guard.
    final var image = getActiveImage();

    return new Dimension(
        image.getWidth( null ), image.getHeight( null )
    );
  }

  @Override
  public Insets getInsets() {
    return INSET_PROJECTED;
  }

  @Override
  protected void paintComponent( final Graphics graphics ) {
    super.paintComponent( graphics );

    final var g = (Graphics2D) graphics.create();
    g.drawImage( getActiveImage(), 0, 0, this );
  }

  /**
   * Repaints this component by changing its mutable state. The new state
   * must have been previously registered via {@link #put(Object, Image)}.
   *
   * @param state The new state.
   */
  public void setState( final S state ) {
    assert state != null;
    mState = state;

    repaint();
  }

  private Image getActiveImage() {
    return getStateImages().get( getState() );
  }

  private S getState() {
    return mState;
  }

  private Map<S, I> getStateImages() {
    return mStateImages;
  }
}
