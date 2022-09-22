import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BestFeaturesTest {

    private BestFeatures bestFeatures;

    @BeforeEach
    void beforeEach(){
        bestFeatures = new BestFeatures();
    }

    @Test
    void collectionListOf(){
        bestFeatures.collectionListOf();
    }

    @Test
    void collectionMapOf(){
        bestFeatures.collectionMapOf();
    }

    @Test
    void collectionMapOfEntries(){
        bestFeatures.collectionMapOfEntries();
    }

    @Test
    void collectionSetOf(){
        bestFeatures.collectionSetOf();
    }

    @Test
    void collectorsToList(){
        bestFeatures.collectorsToList();
    }

    @Test
    void record(){
        bestFeatures.record();
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
    void switchExpressionYield(){
        bestFeatures.switchExpressionYield();
    }

    @Test
    void textBlocks(){
        bestFeatures.textBlocks();
    }

    @Test
    void var(){
        bestFeatures.var();
    }
}