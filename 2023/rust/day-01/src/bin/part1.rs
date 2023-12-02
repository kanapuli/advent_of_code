fn main() {
    let input = include_str!("./input.txt");
    let output = part1(input);
    dbg!(output);
}

fn part1(input: &str) -> String {
    let output: u32 = input
        .lines()
        .map(|line| {
            let mut it = line.chars().filter_map(|character| character.to_digit(10));
            let first = it.next().unwrap();
            match it.last() {
                Some(num) => format!("{first}{num}"),
                None => format!("{first}{first}"),
            }
            .parse::<u32>()
            .unwrap()
        })
        .sum::<u32>();

    output.to_string()
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_part1() {
        use super::*;
        let input = "1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet";
        let actual_output = part1(input);
        assert_eq!(actual_output, "142");
    }
}
