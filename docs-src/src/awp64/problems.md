# Problems at work

---

* **Problem**: Data Management Complexity
* **Solution**: Using _FasterXML_ library to store nested groups/products data as a JSON file

---

* **Problem**: Products names uniqueness and validation
* **Solution**: Using Rust-derived pattern "_newtype_", which gives you the opportunity to validate data during object creation, but not using it; using `HashSet`s with lambda expressions to fastly search for a product/group to ensure its uniequeness

---

* **Problem**: _Swing UI_ development complexity and bad user experience
* **Solution**: Developing own declarative UI framework Swelm based on Swing and inspired by _Flutter_ and _Relm_ frameworks

---

* **Problem**: Search Functionality Optimization
* **Solution**: Using regular expressions to ensure correct search queries and using lambda expressions and HashSets for a fast search

---

* **Problem**: Using multiple working context in a single app
* **Solution**: Implementing _`Screen`_ abstract class to easily switch working context without data loss

---