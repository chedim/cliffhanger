mod statemachine;

use statemachine::StateMachine;

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_startup() {
        let machine = StateMachine::new();
    }
}

fn main() {
    println!("Hello, world!");
}
