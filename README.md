# Android-menu

Android 的上下文菜单类似于 PC 上的右键菜单。当为一个视图注册了上下文菜单之后，长按（2 秒左右）这个视图对象就会弹出一个浮动菜单，即上下文菜单。任何视图都可以注册上下文菜单，不过，最常见的是用于列表视图ListView的item。

注意：Android 的上下文菜单不支持图标或快捷键。

 

**创建一个上下文菜单的步骤：**

1. 覆盖 Activity 的 onCreateContenxtMenu() 方法，调用 Menu 的 add 方法添加菜单项（MenuItem）。

2. 覆盖 Activity 的 onContextItemSelected() 方法，响应上下文菜单菜单项的单击事件。

3. 调用 registerForContextMenu() 方法，为视图注册上下文菜单。

