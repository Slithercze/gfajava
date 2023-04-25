package gardenspeedrun;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlantTest {
  private Plant plant;

  @Test
  @DisplayName("Flower watering with 0 - should not change level of water")
  void wateringWithZero() {
    // arrange
    plant = new Flower("pink");
    int amount = 0;
    double expected = plant.getWaterLevel();
    // act
    plant.absorbWater(amount);
    // assert
    assertEquals(expected, plant.getWaterLevel());
  }


  @Test
  @DisplayName("Flower watering with negative number - should throw exception")
  void waterFlowerWithNegativeAmount() {
    // arrange
    int amount = -3;
    plant = new Flower("black");
    // act + assert
    assertThrows(IllegalArgumentException.class, () -> plant.absorbWater(amount));
  }
}
