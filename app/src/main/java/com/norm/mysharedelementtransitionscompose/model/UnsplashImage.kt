package com.norm.mysharedelementtransitionscompose.model

data class UnsplashImage(
    val id: Int,
    val photo: String,
    val author: String,
    val location: String,
    val about: String,
)

val items = listOf(
    UnsplashImage(
        id = 1,
        photo = "https://loremflickr.com/256/256/cat",
        author = "Sergey Bezborodov",
        location = "RU, Novosibirsk",
        about = "This curious kitty loves exploring every nook and cranny of the house, always on the lookout for new adventures.",
    ),
    UnsplashImage(
        id = 2,
        photo = "https://loremflickr.com/256/256/cat",
        author = "Diana Pavlova",
        location = "RU, Moscow",
        about = "The graceful feline moves with an effortless elegance, captivating everyone with its beauty and poise.",
    ),
    UnsplashImage(
        id = 3,
        photo = "https://loremflickr.com/256/256/cat",
        author = "Julia Timoshenko",
        location = "CH, Berne",
        about = "This playful purrer can't resist a good game, always ready to chase after a toy or a shadow.",
    ),
    UnsplashImage(
        id = 4,
        photo = "https://loremflickr.com/256/256/cat",
        author = "Egor Shalkov",
        location = "Ru, St.Petersburg",
        about = "The majestic mouser stalks its prey with precision and stealth, showcasing its natural hunting instincts.",
    ),
    UnsplashImage(
        id = 5,
        photo = "https://loremflickr.com/256/256/cat",
        author = "Buianto Erdineev",
        location = "Ru, Ulan - Ude",
        about = "With its sleek silhouette, this cat glides through the room like a shadow, leaving an impression of effortless grace.",
    ),
    UnsplashImage(
        id = 6,
        photo = "https://loremflickr.com/256/256/cat",
        author = "Ksenia Shuina",
        location = "CHN , Beijing",
        about = "This affectionate ball of fur loves cuddling and purring, making it the perfect companion for cozy evenings.",
    ),
    UnsplashImage(
        id = 7,
        photo = "https://loremflickr.com/256/256/cat",
        author = "Egor Shalkov",
        location = "Ru, St.Petersburg",
        about = "With an independent spirit, this cat marches to the beat of its own drum, valuing its freedom above all."
    ),
    UnsplashImage(
        id = 8,
        photo = "https://loremflickr.com/256/256/cat",
        author = "Buianto Erdineev",
        location = "Ru, Ulan - Ude",
        about = "The elegant hunter combines beauty with skill, effortlessly capturing the attention of both admirers and prey.",
    ),
    UnsplashImage(
        id = 9,
        photo = "https://loremflickr.com/256/256/cat",
        author = "Diana Pavlova",
        location = "RU, Moscow",
        about = "As a cuddly companion, this cat offers warmth and affection, always there to comfort and cheer up its human friends.",
    ),
)