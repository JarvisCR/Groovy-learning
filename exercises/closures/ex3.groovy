def numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

def filter_number = numbers.findAll {it > 3}
                            .collect {it * 3}
                            .sum()

println(filter_number)