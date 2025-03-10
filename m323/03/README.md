| Aufgabe                  | Nur ein Rückgabewert | Resultat nur abhängig von übergebenen Parametern | Verändert keine existierenden Werte | Pure oder Impure |
| ------------------------ | -------------------- | ------------------------------------------------ | ----------------------------------- | ---------------- |
| 1.1 addToCart            | Ja                   | Nein                                             | Nein                                | Impure           |
| 1.2 add                  | Ja                   | Ja                                               | Ja                                  | Pure             |
| 1.3 firstCharacter       | Ja                   | Ja                                               | Ja                                  | Pure             |
| 1.4 multiplyWithRandom   | Ja                   | Nein                                             | Ja                                  | Impure           |
| 1.5 divideNumbers        | Ja                   | Ja                                               | Ja                                  | Pure             |
| 1.6 printAndReturnString | Ja                   | Ja                                               | Nein                                | Impure           |

### Erklärung der Bewertung:

1. **addToCart**: Verändert die globale Variable `cartItems`, daher ist sie impure.
2. **add**: Hängt nur von den Parametern ab, verändert keine externen Werte, daher pure.
3. **firstCharacter**: Gibt nur das erste Zeichen zurück, keine Seiteneffekte, daher pure.
4. **multiplyWithRandom**: Enthält `Math.random()`, daher nicht deterministisch und impure.
5. **divideNumbers**: Berechnet nur eine Division, keine Seiteneffekte, daher pure.
6. **printAndReturnString**: Gibt die Zeichenkette aus (`console.log`), wodurch ein Seiteneffekt entsteht, daher impure.

---

## Aufgabe 2 - Umformulierung der impure Funktionen

### 2.1 `addToCart` (pure Version)
#### JavaScript:
```js
function addToCart(cartItems, item) {
    return [...cartItems, item];
}

const cart = [];
console.log(addToCart(cart, 'Apple'));  // ['Apple']
console.log(addToCart(cart, 'Banana')); // ['Banana']
```
#### Scala:
```scala
def addToCart(cartItems: List[String], item: String): List[String] = {
  cartItems :+ item
}
```

### 2.2 `multiplyWithRandom` (pure Version nicht möglich)
Da `Math.random()` bzw. `Random.nextDouble()` in Scala nicht deterministisch ist, kann diese Funktion nicht wirklich pure sein. Eine Alternative wäre, den Zufallswert als Parameter zu übergeben:

#### JavaScript:
```js
function multiplyWithRandom(number, randomValue) {
    return number * randomValue;
}
```
#### Scala:
```scala
def multiplyWithRandom(number: Double, randomValue: Double): Double = {
  number * randomValue
}
```

### 2.3 `printAndReturnString` (pure Version)
Statt `console.log` kann man die Zeichenkette einfach zurückgeben und das Logging außerhalb der Funktion durchführen:

#### JavaScript:
```js
function returnString(str) {
    return str;
}
```
#### Scala:
```scala
def returnString(str: String): String = str
```

---

## Aufgabe 3 - Eigene pure rekursive Funktionen

### 3.1 Summe einer Liste berechnen
#### JavaScript:
```js
function sumList(numbers) {
    if (numbers.length === 0) return 0;
    return numbers[0] + sumList(numbers.slice(1));
}
```
#### Scala:
```scala
def sumList(numbers: List[Int]): Int = numbers match {
  case Nil => 0
  case head :: tail => head + sumList(tail)
}
```

### 3.2 Mittelwert einer Liste berechnen
#### JavaScript:
```js
function averageList(numbers) {
    function helper(sum, count, list) {
        if (list.length === 0) return sum / count;
        return helper(sum + list[0], count + 1, list.slice(1));
    }
    return numbers.length === 0 ? 0 : helper(0, 0, numbers);
}
```
#### Scala:
```scala
def averageList(numbers: List[Double]): Double = {
  def helper(sum: Double, count: Int, list: List[Double]): Double = list match {
    case Nil => sum / count
    case head :: tail => helper(sum + head, count + 1, tail)
  }
  if (numbers.isEmpty) 0 else helper(0, 0, numbers)
}
```

### 3.3 Alphabetische Sortierung
#### JavaScript:
```js
function sortStrings(list) {
    if (list.length <= 1) return list;
    const [pivot, ...rest] = list;
    return [...sortStrings(rest.filter(x => x < pivot)), pivot, ...sortStrings(rest.filter(x => x >= pivot))];
}
```
#### Scala:
```scala
def sortStrings(list: List[String]): List[String] = list match {
  case Nil => Nil
  case head :: tail =>
    sortStrings(tail.filter(_ < head)) ::: head :: sortStrings(tail.filter(_ >= head))
}
```

### 3.4 Sortierte Liste von Objekten
#### JavaScript:
```js
function sortObjects(list) {
    return list.sort((a, b) => a.date - b.date || a.priority - b.priority || a.title.localeCompare(b.title));
}
```
#### Scala:
```scala
def sortObjects(list: List[(String, Int, String)]): List[(String, Int, String)] = {
  list.sortBy { case (date, priority, title) => (date, priority, title) }
}
```

### 3.5 Blätter aus Baumstruktur extrahieren
#### JavaScript:
```js
function getLeaves(tree) {
    if (!tree.children || tree.children.length === 0) return [tree.value];
    return tree.children.flatMap(getLeaves);
}
```
#### Scala:
```scala
case class Tree(value: Int, children: List[Tree])

def getLeaves(tree: Tree): List[Int] = tree.children match {
  case Nil => List(tree.value)
  case _   => tree.children.flatMap(getLeaves)
}
```

