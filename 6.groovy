long sum = 0

(1..100).each{i->
    (1..100).each{j->
        if (i != j) { sum+= i * j }
    }
}

return sum