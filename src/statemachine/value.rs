pub enum Value {
    Flag(bool),
    Integer(i32),
    Fraction(f32),
    Glyph(char),
    Text(String),
    Set(Vec<Value>)
}
