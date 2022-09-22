import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BestFeaturesTest {

    private BestFeatures bestFeatures;

    @BeforeEach
    void beforeEach(){
        bestFeatures = new BestFeatures();
    }

    @Test
    void collectorsToList(){
        bestFeatures.collectorsToList();
    }

    @Test
    void patternMatchingInstanceOf(){
        bestFeatures.patternMatchingInstanceOf();
    }

    @Test
    void switchExpression(){
        bestFeatures.switchExpression();
    }

    @Test
    void textBlocks(){
        bestFeatures.textBlocks();
    }
}