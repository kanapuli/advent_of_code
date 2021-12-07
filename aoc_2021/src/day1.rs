const INPUT: &'static str = include_str!("../inputs/1.txt");

pub fn run() {
    let count = parse(INPUT);
    println!("number bigger than: {}", count);
}

fn parse(input: &str) -> usize {
    let lines: Vec<u16> = input
        .lines()
        .map(|line| line.parse::<u16>().unwrap())
        .collect();

    let count = lines
        .array_windows()
        .filter_map(|[n1, n2]| (n2 > n1).then(|| ()))
        .count();

    count
}

#[cfg(test)]
mod test {
    use super::*;
    #[test]
    fn smoke() {
        let input = "199
200
208
210
200
207
240
269
260
263";

        let count = parse(input);
        assert_eq!(count, 7);
    }
}
