### Tech Task

This is the android codebase for simple Ecommerce application to display the home feed section dhnamically

- [Description](#description)
- [Platform](#platform)
- [How to run the code base](#how-to-run-the-code-base)
- [Modules](#modules)
- [Code Flow](#code-flow)
- [Screen Grabs](#screen-grabs)


### Description

Create a native app that hits the API mentioned and render in the UI but keep it simple.
API: https://jsonkeeper.com/b/5BEJ

The above API provides a JSON with list of blocks where each block is of different type, Filter
the section types from the json and render them accordingly.

Each block description is as follows:

1. "sectionType":"horizontalFreeScroll" => this block should display the
   provided products as a horizontal free scrolling list.
   a. Each product width is 124, and all the strings are single line
   b. Image height is 124
2. "sectionType":"splitBanner" => Displays two images on screen( equal
   widths).
   a. Height is 240dp
3. "sectionType":"banner" => Displays Image by occupying full screen
   width.
   a. Height is 240dp


### Platform

- Compile SDK 34
- Min SDK 23
- Target SDK 34

### How to run the code base

- Download the latest stable Android Studio
- Clone the project into the desktop and use the above IDE to open the project
- Clean and Build the project
- Run the codebase into an emulator of your choice or any real devices
- You can change the BackEndUrl for the 3 flavors under buildSrc folder in BackEndURL object

### Modules

- Can be found under Modules OverView folder in the root project

![Modules](https://github.com/GeorgePeterPandian/ECommerce/blob/main/Modules%20Overview/ModulesOverview.png)

- **`ECommerce:`** The source code for Android Application.
- **`buildSrc:`** The build source files related to the project resides in here. Custom Android
  Application, Android Library, Kotlin Library and Plugin extensions resides here.
- **`core:`** The common core classes used across domain, data and UI layer resides here.
- **`network-common:`** The common classes required to do network call like common retrofit and
  okhttp resides here.
- **`products-data:`** This module contains the data layer logic shown in the code flow diagram under
  code flow folder in the root project.
- **`products-domain:`** This module contains the domain layer logic shown in the code flow diagram
  under code flow folder in the root project.


### Code Flow

- Can be found under Code Flow folder in the root project

![CodeFlow](https://github.com/GeorgePeterPandian/ECommerce/blob/main/CodeFlow/Ecommerce.png)


### Screen Grabs

The Screen Grabs can be found under ScreenShots folder

###  Light Mode

![alt text](https://github.com/GeorgePeterPandian/ECommerce/blob/main/Screenshots/LightMode/Screenshot_20240918-081622.png)


![alt text](https://github.com/GeorgePeterPandian/ECommerce/blob/main/Screenshots/LightMode/Screenshot_20240918-081627.png)



### Dark Mode

![alt text](https://github.com/GeorgePeterPandian/ECommerce/blob/main/Screenshots/DarkMode/Screenshot_20240918-081553.png)

![alt text](https://github.com/GeorgePeterPandian/ECommerce/blob/main/Screenshots/DarkMode/Screenshot_20240918-081601.png)
