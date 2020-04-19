package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void testFoo() {
    	Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    public void testNegativeQuality() {
    	GildedRose app = checkItem("foo", 0,-1);
    	assertEquals(-1,app.items[0].quality);
    }
    
    @Test
    public void testMaxQuality() {
    	GildedRose app = checkItem("bar",10, 71);
    	assertEquals(69, app.items[0].quality);
    }
    
    @Test
    public void testUnexpiredAgedBrie() {
    	GildedRose app = checkItem("Aged Brie",1, 0);
    	assertEquals(2, app.items[0].quality);
    }
    
    public static void main(String[] args)
    {
    	Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
    }

    public GildedRose checkItem(String item, Integer sellin, Integer quality) {
		Item[] items = new Item[] { new Item(item, sellin, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		return app;
	}
}
