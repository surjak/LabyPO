package main.agh.cs.lab6;

import main.agh.cs.lab3.Position;

public interface IPositionChangeObserver {
  void positionChanged(Position oldPosition, Position newPosition);
}
