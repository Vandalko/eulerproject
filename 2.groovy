def fib = 1
def prev = 1
def sum = 0
while (fib < 4000000) {
    if (fib % 2 == 0) { sum += fib }
    def prevFib = fib
    fib += prev
    prev = prevFib
}

return sum