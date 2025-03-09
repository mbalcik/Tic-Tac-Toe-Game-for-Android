package com.example.comp319p2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comp319p2.ui.theme.Comp319P2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Comp319P2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameTable()
                }
            }
        }
    }
}


@Composable
fun GameTable() {
    val scoreX = remember { mutableIntStateOf(0) }
    val scoreO = remember { mutableIntStateOf(0) }
    val draw = remember { mutableIntStateOf(0) }
    val xTurn = remember { mutableStateOf(true) }
    val gameOver = remember { mutableStateOf(false) }
    val turnString = remember {
        mutableStateOf("X")
    }
    val imageList = remember {
        mutableStateListOf(
            R.drawable.empty, R.drawable.empty, R.drawable.empty,
            R.drawable.empty, R.drawable.empty, R.drawable.empty,
            R.drawable.empty, R.drawable.empty, R.drawable.empty
        )
    }

    fun checkGameEnd(): Int {
        if (imageList[0] == R.drawable.letter_x && imageList[1] == R.drawable.letter_x && imageList[2] == R.drawable.letter_x) {
            imageList[0] = R.drawable.red_letter_x
            imageList[1] = R.drawable.red_letter_x
            imageList[2] = R.drawable.red_letter_x
            return 0
        }
        if (imageList[3] == R.drawable.letter_x && imageList[4] == R.drawable.letter_x && imageList[5] == R.drawable.letter_x) {
            imageList[3] = R.drawable.red_letter_x
            imageList[4] = R.drawable.red_letter_x
            imageList[5] = R.drawable.red_letter_x
            return 0
        }
        if (imageList[6] == R.drawable.letter_x && imageList[7] == R.drawable.letter_x && imageList[8] == R.drawable.letter_x) {
            imageList[6] = R.drawable.red_letter_x
            imageList[7] = R.drawable.red_letter_x
            imageList[8] = R.drawable.red_letter_x
            return 0
        }
        if (imageList[0] == R.drawable.letter_x && imageList[3] == R.drawable.letter_x && imageList[6] == R.drawable.letter_x) {
            imageList[0] = R.drawable.red_letter_x
            imageList[3] = R.drawable.red_letter_x
            imageList[6] = R.drawable.red_letter_x
            return 0
        }
        if (imageList[1] == R.drawable.letter_x && imageList[4] == R.drawable.letter_x && imageList[7] == R.drawable.letter_x) {
            imageList[1] = R.drawable.red_letter_x
            imageList[4] = R.drawable.red_letter_x
            imageList[7] = R.drawable.red_letter_x
            return 0
        }
        if (imageList[2] == R.drawable.letter_x && imageList[5] == R.drawable.letter_x && imageList[8] == R.drawable.letter_x) {
            imageList[2] = R.drawable.red_letter_x
            imageList[5] = R.drawable.red_letter_x
            imageList[8] = R.drawable.red_letter_x
            return 0
        }
        if (imageList[0] == R.drawable.letter_x && imageList[4] == R.drawable.letter_x && imageList[8] == R.drawable.letter_x) {
            imageList[0] = R.drawable.red_letter_x
            imageList[4] = R.drawable.red_letter_x
            imageList[8] = R.drawable.red_letter_x
            return 0
        }
        if (imageList[2] == R.drawable.letter_x && imageList[4] == R.drawable.letter_x && imageList[6] == R.drawable.letter_x) {
            imageList[2] = R.drawable.red_letter_x
            imageList[4] = R.drawable.red_letter_x
            imageList[6] = R.drawable.red_letter_x
            return 0
        }
        if (imageList[0] == R.drawable.letter_o && imageList[1] == R.drawable.letter_o && imageList[2] == R.drawable.letter_o) {
            imageList[0] = R.drawable.red_letter_o
            imageList[1] = R.drawable.red_letter_o
            imageList[2] = R.drawable.red_letter_o
            return 1
        }
        if (imageList[3] == R.drawable.letter_o && imageList[4] == R.drawable.letter_o && imageList[5] == R.drawable.letter_o) {
            imageList[3] = R.drawable.red_letter_o
            imageList[4] = R.drawable.red_letter_o
            imageList[5] = R.drawable.red_letter_o
            return 1
        }
        if (imageList[6] == R.drawable.letter_o && imageList[7] == R.drawable.letter_o && imageList[8] == R.drawable.letter_o) {
            imageList[6] = R.drawable.red_letter_o
            imageList[7] = R.drawable.red_letter_o
            imageList[8] = R.drawable.red_letter_o
            return 1
        }
        if (imageList[0] == R.drawable.letter_o && imageList[3] == R.drawable.letter_o && imageList[6] == R.drawable.letter_o) {
            imageList[0] = R.drawable.red_letter_o
            imageList[3] = R.drawable.red_letter_o
            imageList[6] = R.drawable.red_letter_o
            return 1
        }
        if (imageList[1] == R.drawable.letter_o && imageList[4] == R.drawable.letter_o && imageList[7] == R.drawable.letter_o) {
            imageList[1] = R.drawable.red_letter_o
            imageList[4] = R.drawable.red_letter_o
            imageList[7] = R.drawable.red_letter_o
            return 1
        }
        if (imageList[2] == R.drawable.letter_o && imageList[5] == R.drawable.letter_o && imageList[8] == R.drawable.letter_o) {
            imageList[2] = R.drawable.red_letter_o
            imageList[5] = R.drawable.red_letter_o
            imageList[8] = R.drawable.red_letter_o
            return 1
        }
        if (imageList[0] == R.drawable.letter_o && imageList[4] == R.drawable.letter_o && imageList[8] == R.drawable.letter_o) {
            imageList[0] = R.drawable.red_letter_o
            imageList[4] = R.drawable.red_letter_o
            imageList[8] = R.drawable.red_letter_o
            return 1
        }
        if (imageList[2] == R.drawable.letter_o && imageList[4] == R.drawable.letter_o && imageList[6] == R.drawable.letter_o) {
            imageList[2] = R.drawable.red_letter_o
            imageList[4] = R.drawable.red_letter_o
            imageList[6] = R.drawable.red_letter_o
            return 1
        }
        var drawBool = true
        for(i in 0..8)
            if (imageList[i] == R.drawable.empty)
                drawBool = false

        if (drawBool){
            return 2
        }
        return 3
    }

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    )
    {
        Text(
            text = "Player 'O': ${scoreO.intValue}", fontSize = 24.sp
        )
        Text(
            text = "Draw: ${draw.intValue} ", fontSize = 24.sp
        )
        Text(
            text = "Player 'X': ${scoreX.intValue}", fontSize = 24.sp

        )
    }
    Column(
        modifier = Modifier.padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.tictactoe), contentDescription = "Name")
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(imageList) { index, image ->
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clickable {
                            if (!gameOver.value) {
                                if (xTurn.value && imageList[index] == R.drawable.empty) {
                                    imageList[index] = R.drawable.letter_x
                                    xTurn.value = false
                                    turnString.value = "O"
                                } else if (imageList[index] == R.drawable.empty) {
                                    imageList[index] = R.drawable.letter_o
                                    xTurn.value = true
                                    turnString.value = "X"
                                }
                                val winner = checkGameEnd()
                                println(winner)
                                if (winner != 3) {
                                    gameOver.value = true
                                    when (winner) {
                                        0 -> scoreX.intValue += 1
                                        1 -> scoreO.intValue += 1
                                        2 -> draw.intValue += 1
                                    }
                                }
                            }
                        },
                    painter = painterResource(id = image),
                    contentDescription = "Displayed Image",
                )
            }
        }


        Row (
            modifier = Modifier.padding(top = 50.dp)
        ){
            Text(text = "Player ${turnString.value}'s turn", fontSize = 32.sp, color = Color.Blue)
            Spacer(modifier = Modifier.width(40.dp))
            Button(onClick = {
                for (i in 0..8) {
                    imageList[i] = R.drawable.empty
                }
                gameOver.value = false
            }) {
                Text(text = "Reset Game")
            }
        }
    }
}