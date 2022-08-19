# UserAuth

使用compose for Desktop 實作登入註冊UI

## Note

### MutableState & remember

***MutableState***

Jetpack Compose中所提供用來儲存狀態的一個interface，mutableStateOf 會建立一個可觀察的`MutableState<T>`，這是一種整合 Compose 執行階段的可觀察類型。
可以使用mutableStateOf去控制畫面上目前是顯示那個Screen

***remember***

remember 可用來儲存可變動與不可變動的物件，可在Composable函式中使用`remember`記住狀態，並且在初始化時會將`remember`初始的值儲存在Composable函式中，當值有所變更中有可以回傳新的值
用來計算的值會在初始組成期間儲存在「組成」中，並在重新組成時傳回所儲存的值。

透過MutableState搭配remember API的使用可以控制控制畫面上物件狀態，包含Screen的內容

```
val screen: MutableState<Screen> = remember { mutableStateOf(Screen.MainScreen) }
    .
    .
    .
when (screen.value) {
    Screen.MainScreen -> mainScreen.mainScreen()
    Screen.LoginScreen -> loginScreen.LoginScreen() { screen.value = Screen.MainScreen }
    Screen.RegisterScreen -> registerScreen.RegisterScreen() { screen.value = Screen.MainScreen }
}
    .
    .
    .  

```

### Scaffold

Jetpack Compose中所提供的一種UI layout的API函式

```
Scaffold(
    modifier = Modifier.fillMaxSize(),
    scaffoldState = scaffoldState,
    content = {
        // TODO content
    }
)
```

or

```
Scaffold(
    modifier = Modifier.fillMaxSize(),
    scaffoldState = scaffoldState,
){
    // TODO content
}

```

### Column

與`Row` 都是在用Composable函式中，替UI進行排列元件API元素，`Column`會將內部元件中進行縱向排列，而`Row`則會進行橫向排列

### TextField、Spacer、Button＆Text

TextField、Spacer、Button＆Text以上都是由Jetpack Compose中所提供，可以在Composable函式中使用UI相關API函數。

TextField: 建立一個可以接受文字輸入UI元件

```
 TextField(
    value = textFieldStatePassword,
    label = {
        Text("Enter your Password")
    },
    onValueChange = {
        textFieldStatePassword = it
    }
)
```

Spacer:可以用於在View建立空間(間隔?)

```
Spacer(modifier = Modifier.height(16.dp))
```

Button: 按鈕元件

```
 Button(onClick = {
    // TODO onClick Action    
}) {
    Text("Login")
}
```

Text: 用於顯示文字內容UI元件

```
Text("Login")
```

## Reference

1. [Creating User Authentication UI with Compose for Desktop](https://www.section.io/engineering-education/creating-user-authentication-ui-with-compose-for-desktop/)

2. [Compose Multiplatform Getting started](https://github.com/JetBrains/compose-jb/tree/master/tutorials/Getting_Started)

3. [Jetpack Compose](https://developer.android.com/jetpack/compose?gclid=CjwKCAjw6fyXBhBgEiwAhhiZsuAdsWDwGmCAUWBykcqPH9qNHbJdxmLwqSMmHWAyNhcob4ZABawUWRoCpZ4QAvD_BwE&gclsrc=aw.ds)