package uk.co.lunalux.libos;

public class Window extends Defines
{
    public enum mouseButton
    {
        RIGHT,
        OS_MIDDLE,
        LEFT,
    }
    public enum keyboardButton
    {
        KEY_0,
        KEY_1,
        KEY_2,
        KEY_3,
        KEY_4,
        KEY_5,
        KEY_6,
        KEY_7,
        KEY_8,
        KEY_9,
        KEY_A,
        KEY_B,
        KEY_C,
        KEY_D,
        KEY_E,
        KEY_F,
        KEY_G,
        KEY_H,
        KEY_I,
        KEY_J,
        KEY_K,
        KEY_L,
        KEY_M,
        KEY_N,
        KEY_O,
        KEY_P,
        KEY_Q,
        KEY_R,
        KEY_S,
        KEY_T,
        KEY_U,
        KEY_V,
        KEY_W,
        KEY_X,
        KEY_Y,
        KEY_Z,
        KEY_APOSTROPHE,
        KEY_BACKSLASH,
        KEY_COMMA,
        KEY_LEFT_BRACKET,
        KEY_MINUS,
        KEY_PERIOD,
        KEY_RIGHT_BRACKET,
        KEY_SEMICOLON,
        KEY_SLASH,
        KEY_BACKSPACE,
        KEY_DELETE,
        KEY_END,
        KEY_ENTER,
        KEY_ESCAPE,
        KEY_HOME,
        KEY_INSERT,
        KEY_PAGE_DOWN,
        KEY_PAGE_UP,
        KEY_PAUSE,
        KEY_SPACE,
        KEY_TAB,
        KEY_CAPS_LOCK,
        KEY_NUM_LOCK,
        KEY_SCROLL_LOCK,
        KEY_F1,
        KEY_F2,
        KEY_F3,
        KEY_F4,
        KEY_F5,
        KEY_F6,
        KEY_F7,
        KEY_F8,
        KEY_F9,
        KEY_F10,
        KEY_F11,
        KEY_F12,
        KEY_F13,
        KEY_F14,
        KEY_F15,
        KEY_F16,
        KEY_F17,
        KEY_F18,
        KEY_F19,
        KEY_F20,
        KEY_F21,
        KEY_F22,
        KEY_F23,
        KEY_F24,
        KEY_ALT,
        KEY_LEFT_ALT,
        KEY_RIGHT_ALT,
        KEY_CONTROL,
        KEY_LEFT_CONTROL,
        KEY_RIGHT_CONTROL,
        KEY_SHIFT,
        KEY_LEFT_SHIFT,
        KEY_RIGHT_SHIFT,
        KEY_LEFT_SUPER,
        KEY_RIGHT_SUPER,
        KEY_PRINT_SCREEN,
        KEY_DOWN,
        KEY_LEFT,
        KEY_RIGHT,
        KEY_UP,
        KEY_NUM_PAD_0,
        KEY_NUM_PAD_1,
        KEY_NUM_PAD_2,
        KEY_NUM_PAD_3,
        KEY_NUM_PAD_4,
        KEY_NUM_PAD_5,
        KEY_NUM_PAD_6,
        KEY_NUM_PAD_7,
        KEY_NUM_PAD_8,
        KEY_NUM_PAD_9,
        KEY_ADD,
        KEY_DECIMAL,
        KEY_DIVIDE,
        KEY_EQUAL,
        KEY_MULTIPLY,
        KEY_SUBTRACT,
    }
    public class windowInfo
    {
        int sub_window;
        losSize window_size;
        String title;
        long title_size;
    }
    public class position
    {
        int x;
        int y;
    }

    public native losResult createWindow(windowInfo info);
    public native losResult createKeyboard();
    public native losResult createMouse();
    public native losResult createTouch();

    //the way to check if the window should close check to see if function returns "WINDOW_CLOSE"
    public native losResult losUpdateWindow();
    //--------------------------------------------------------------------------------------------------------------------------
    public native Boolean isKeyDown(keyboardButton key);
    public native Boolean isMouseDown(mouseButton button);
    public native losResult requestClose();
    public native position requestMousePosition();
    public native position requestMouseWheelDelta();
    public native position isBeingPressed();

    public native losResult destroyKeyboard();
    public native losResult destroyMouse();
    public native losResult destroyTouch();
    public native losResult destroyWindow();
}
