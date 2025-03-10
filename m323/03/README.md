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




