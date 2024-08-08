# Momentum Block Shuffler (MBS), for Minecraft Parkour (MCPK)
## What is this?
This is a tool that I made that lets you easily check every possbile way to build a certain jump, to quickly see if it is buildable or not. You can draw a jump with the required dimensions that you need, then it will figure out every way to build it with minecraft blocks.

<img width="960" alt="example" src="https://github.com/user-attachments/assets/ba58e170-7556-404b-a85f-c505479c604d">

## How to use
Dragging your mouse with left click will create a blue collision box.

![left_drag](https://github.com/user-attachments/assets/0ba4642d-46c9-4e17-af6b-d91ebe495599)

Dragging with right click will also work, but will instead create a red collision box. If using red, it will allow blocks that might be "cheesable". For example, piston heads and stairs are among those blocks since they have a "lower" part to them.

![right_drag](https://github.com/user-attachments/assets/635aea14-679f-4af0-b4cb-c5acda852c19)

Press BACKSPACE to remove the last drawn hitbox.

![delete](https://github.com/user-attachments/assets/66924643-0d8a-4cfd-890f-dca8f8c20920)

You can move around by dragging with the middle mouse button, and zoom in/out with the scroll wheel.

![zoom](https://github.com/user-attachments/assets/2023378f-8077-4ea4-93cc-90d1829aebf3)

You can click left (increment) or right (decrement) click on the edge of a collision box. It will display a number from 1 to 15 which means how far that direction can the block extend. For example, instead of specifying a jump like 1bm head butterfly by putting a full block for the momentum, you could put a 1x1 pixel at the top right of the momentum and a 1x1 pixel at the bottom left, then allow each to extend 15 pixels inwards. This will make it more flexible and allow it to find more combinations of blocks.

![edge](https://github.com/user-attachments/assets/922fffab-a0f8-42e8-9261-6e2fe015dee2)

Press ENTER once you're ready to search for all momentum combinations.

![final](https://github.com/user-attachments/assets/5d2158a6-cfc9-473c-aa97-293a8a7c0400)

## List of blocks
The list of blocks ignores some duplicated hitboxs (for example, chest is same as egg and cactus...). Here is a list of all possible blocks:
- Block
- Dragon egg
- Anvil
- Ladder
- Trapdoor
- Piston base
- Piston Head
- Cobblewall (and all its facings)
- Thin cobblewall
- Head
- Flower pot
- Fence (and all its facings)
- Pane
- Short pane
- Brewing Stand
- Stair
- Corner stair
- Cocoa (age 1 to 3)
- Double chest (similar to normal chest, but with 1 extra pixel)
- Cake (with all bite stages)

Let me know if I'm forgetting any block!
